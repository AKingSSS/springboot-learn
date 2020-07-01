package com.aking.shiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description
 * @Author yangkang
 * @Date 2020/4/2 0:08
 * @Version 1.0
 **/
@RestController
public class HelloController {
    /**
     * 输出 hello world
     * @return
     */
    @GetMapping(path = {"/helloSpringBoot"})
    public String HelloSpring (){
        System.out.println("hello spring boot");
        return "hello spring boot";
    }

    /**
     * 模拟死循环伪代码
     * @return
     */
    @GetMapping(path = {"/letCpuBusy"})
    public void letCpuBusy (){
        int i=0;
        while(true) {
            i++;
        }
    }

    public static void main(String[] args) {
        while (true) {
            String s = new String("abc");
            List list = new ArrayList();
            list.add(s);
        }
    }
}
