package com.aking.wx.service;

import com.aking.pojo.Template;
import com.soecode.wxtools.bean.result.TemplateSenderResult;

/**
 * @ClassName MyWxService
 * @Description
 * @Author yangkang
 * @Date 2020/5/22 17:20
 * @Version 1.0
 **/
public interface MyWxService {
    /**
     * 接口配置校验
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    boolean checkSignature(String signature, String timestamp, String nonce, String echostr);

    /**
     * access_token 是公众号的全局唯一接口调用凭据
     * @return
     */
    String getAccessToken();

    /**
     * 模板发送
     * @param template
     * @return
     */
    TemplateSenderResult templateSend(Template template);

}
