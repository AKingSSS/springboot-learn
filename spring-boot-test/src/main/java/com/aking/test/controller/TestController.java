package com.aking.test.controller;

import com.aking.test.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author yk
 * @Date 2020/9/10 18:04
 * @Version 1.0
 **/
@RestController
@RequestMapping("/apis")
public class TestController {
    @Autowired
    private HelloService helloService;

    /**
     * hello
     * @param name
     */
    @GetMapping("/say")
    public Boolean sayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
