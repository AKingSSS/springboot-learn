package com.aking.dubbo.consumer.controller;

import com.aking.dubbo.api.service.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
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
public class HelloController {
    @Reference(version = "${dubbo.service.version}",
            group = "${dubbo.provider.group}",
    url = "${dubbo.provider.url}")
    private HelloService helloService;

    @RequestMapping("/hello.do")
    public String sayHello(String name) {
        String s = helloService.sayHello(name);
        return s;
    }
}
