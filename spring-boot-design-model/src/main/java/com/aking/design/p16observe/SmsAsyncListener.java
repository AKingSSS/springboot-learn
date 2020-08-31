package com.aking.design.p16observe;

import com.aking.design.p16observe.service.impl.OrderServiceImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName SmsAsyncListener
 * @Description
 * @Author yk
 * @Date 2020/8/31 18:23
 * @Version 1.0
 **/
@Component
public class SmsAsyncListener implements SmartApplicationListener {

    /**
     * 设置监听优先级
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 监听器智能所在之一，能够根据事件类型动态监听
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }

    /**
     * 监听器智能所在之二，能够根据事件发布者类型动态监听
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == OrderServiceImpl.class;
    }


    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent event = (OrderCreateEvent) applicationEvent;
        //发送微信
        System.out.println(event.getContentList().get(0) +
                ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by wechat");
    }
}
