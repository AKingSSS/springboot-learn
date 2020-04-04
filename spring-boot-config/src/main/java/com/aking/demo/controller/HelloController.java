package com.aking.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloCoontroller
 * @Description
 * @Author yangkang
 * @Date 2020/4/4 14:43
 * @Version 1.0
 **/
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
