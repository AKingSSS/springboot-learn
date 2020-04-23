package com.aking.ioc.service.impl;

import com.aking.ioc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloServiceImpl
 * @Description
 * @Author yangkang
 * @Date 2020/4/22 21:29
 * @Version 1.0
 **/
@Service
public class HelloServiceImpl implements HelloService {
    /**
     * 输出 hello world
     */
    @Override
    public void say() {
        System.out.println("hello world");
    }
}
