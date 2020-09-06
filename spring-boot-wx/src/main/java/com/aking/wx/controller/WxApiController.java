package com.aking.wx.controller;

import com.aking.wx.service.MyWxService;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName WxApiController
 * @Description
 * @Author yk
 * @Date 2020/5/22 17:30
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("wx/api")
public class WxApiController {
    @Autowired
    private MyWxService myWxService;

    /**
     * 用于接口配置信息 token 校验
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping
    public String checkSignature(String signature,
                                 String timestamp,
                                 String nonce,
                                 String echostr){
        if(myWxService.checkSignature(signature,timestamp,nonce,echostr))
            return echostr;
        return "check signature fail";
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 微信服务器推送过来的是XML格式。
            WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
            log.info("消息：\n " + wx.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
