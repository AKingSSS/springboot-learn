package com.aking.design.p16observe;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName SmsListener
 * @Description
 * @Author yk
 * @Date 2020/8/31 17:51
 * @Version 1.0
 **/
@Component
public class SmsListener implements ApplicationListener<OrderCreateEvent>{
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        //发送短信
        System.out.println(event.getContentList().get(0) +
                ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");
    }
}
