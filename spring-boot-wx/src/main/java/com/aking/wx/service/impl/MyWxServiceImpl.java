package com.aking.wx.service.impl;

import com.aking.exception.WxException;
import com.aking.pojo.Template;
import com.aking.wx.service.MyWxService;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.bean.TemplateSender;
import com.soecode.wxtools.bean.result.TemplateSenderResult;
import com.soecode.wxtools.exception.WxErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName MyWxServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/5/22 17:24
 * @Version 1.0
 **/
@Slf4j
@Service
public class MyWxServiceImpl implements MyWxService {

    @Autowired
    private IService iService;

    /**
     * 接口配置校验
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @Override
    public boolean checkSignature(@NotBlank String signature, @NotBlank String timestamp,
                                  @NotBlank String nonce, @NotBlank String echostr) {
        return iService.checkSignature(signature, timestamp, nonce, echostr);
    }

    /**
     * access_token 是公众号的全局唯一接口调用凭据
     *
     * @return
     */
    @Override
    public String getAccessToken() {
        try {
            return iService.getAccessToken();
        } catch (WxErrorException e) {
            log.error("MyWxServiceImpl.getAccessToken WxErrorException: [{}] ", e);
            return null;
        }
    }

    /**
     * 模板发送
     *
     * @param template
     * @return
     */
    @Override
    public TemplateSenderResult templateSend(Template template) throws WxException {
        if (null == template) {
            String msg = "templateSend params is error, template is empty";
            throw new WxException(msg).setShowText(msg);
        }
        if (StringUtils.isEmpty(template.getTouser())) {
            String msg = "templateSend params is error, template.touser is empty";
            throw new WxException(msg).setShowText(msg);
        }
        if (StringUtils.isEmpty(template.getTemplate_id())) {
            String msg = "templateSend params is error, template.template_id is empty";
            throw new WxException(msg).setShowText(msg);
        }
        if (null == template.getData()) {
            String msg = "templateSend params is error, template.data is empty";
            throw new WxException(msg).setShowText(msg);
        }
        try {
            TemplateSender templateSender = new TemplateSender();
            templateSender.setTouser(template.getTouser());
            templateSender.setTemplate_id(template.getTemplate_id());
            templateSender.setUrl(template.getUrl());
            templateSender.setData(template.getData());
            TemplateSenderResult templateSenderResult = iService.templateSend(templateSender);
            return templateSenderResult;
        } catch (WxErrorException e) {
            log.error("WxAPIProvider.templateSend WxErrorException : " + e.getError().toString() + ",Template:[{}]", template, e);
            String msg = e.getError().toString();
            throw new WxException(msg).setShowText(msg);
        }
    }
}
