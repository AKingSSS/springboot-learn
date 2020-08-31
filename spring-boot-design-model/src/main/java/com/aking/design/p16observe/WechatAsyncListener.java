package com.aking.design.p16observe;

import com.aking.design.p16observe.service.impl.OrderServiceImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName WechatAsyncListener
 * @Description
 * @Author yk
 * @Date 2020/8/31 18:24
 * @Version 1.0
 **/
@Component
public class WechatAsyncListener implements SmartApplicationListener {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == OrderServiceImpl.class;
    }

    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent event = (OrderCreateEvent) applicationEvent;
        //发送短信
        System.out.println(event.getContentList().get(0) +
                ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");
    }
}
