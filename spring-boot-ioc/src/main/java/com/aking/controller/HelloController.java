package com.aking.controller;

import com.aking.ioc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author yk
 * @Date 2020/4/29 15:50
 * @Version 1.0
 **/
@RestController
public class HelloController {

    @GetMapping("/hello1")
    public String hello1(String name) {
        return "hello " + name;
    }

    @GetMapping("/hello2")
    public String hello2(String name) {
        return "hello " + name;
    }

    @GetMapping("/hello3")
    public String hello3(String name) {
        return "hello " + name;
    }
}
