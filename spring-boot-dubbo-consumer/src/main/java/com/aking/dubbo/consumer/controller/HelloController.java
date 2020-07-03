package com.aking.dubbo.consumer.controller;

import com.aking.dubbo.api.service.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author yangkang
 * @Date 2020/4/6 11:53
 * @Version 1.0
 **/
@RestController
@Slf4j
public class HelloController {
    @Reference(version = "${dubbo.service.version}", group = "${dubbo.provider.group}")
    private HelloService helloService;

    @RequestMapping("/hello.do")
    public String sayHello() throws InterruptedException {
        // 测试 zk 宕机，服务消费情况
        log.info("第 1 次消费：[{}]",
                helloService.sayHello("Python大星"));
        Thread.sleep(1000 * 20);
        log.info("第 2 次消费：[{}]",
                helloService.sayHello("Python小星"));
        return "success";
    }
}
