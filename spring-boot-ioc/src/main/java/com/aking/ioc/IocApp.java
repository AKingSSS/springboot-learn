package com.aking.ioc;

import com.aking.ioc.service.ActivityService;
import com.aking.ioc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName IocApp
 * @Description
 * @Author yangkang
 * @Date 2020/4/22 21:33
 * @Version 1.0
 **/
public class IocApp {
    public static void main(String[] args) {

        // 用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("context 启动成功");

        // 容器获取 helloService bean
        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.say();

        // 容器获取 ActivityService bean
        ActivityService activityService = (ActivityService) context.getBean("activityServiceImpl");
        activityService.join();
    }
}
