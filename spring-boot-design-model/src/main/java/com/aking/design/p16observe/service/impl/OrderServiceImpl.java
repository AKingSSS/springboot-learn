package com.aking.design.p16observe.service.impl;

import com.aking.design.p16observe.OrderCreateEvent;
import com.aking.design.p16observe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @ClassName OrderServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/8/31 17:47
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
/*    *//**
     * 下单
     *//*
    @Override
    public void saveOrder() {
        //1.创建订单
        System.out.println("下单成功");
        //2.发送短信
        System.out.println("恭喜您下单成功！-- 短信平台");
        //3.微信提醒
        System.out.println("恭喜您下单成功！-- 微信平台");
    }*/

    @Resource
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void saveOrder() {
        //1.创建订单
        System.out.println("订单创建成功");
        //2.发布事件
        ArrayList<String> contentList = new ArrayList<>();
        contentList.add("Python大星");
        contentList.add("123456789");
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(this, "订单创建", contentList);
        applicationContext.publishEvent(orderCreateEvent);
        //ApplicationContext是我们的事件容器上层，我们发布事件，也可以通过此容器完成发布
        //applicationEventPublisher.publishEvent(orderCreateEvent);//也可以
        System.out.println("finished!");
    }
}
