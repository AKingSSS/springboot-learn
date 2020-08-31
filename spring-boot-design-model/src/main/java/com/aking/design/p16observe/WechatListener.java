package com.aking.design.p16observe;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName WechatListener
 * @Description
 * @Author yk
 * @Date 2020/8/31 17:53
 * @Version 1.0
 **/
@Component
public class WechatListener implements ApplicationListener<OrderCreateEvent>  {
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        //发送微信
        System.out.println(event.getContentList().get(0) +
                ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by wechat");
    }
}
