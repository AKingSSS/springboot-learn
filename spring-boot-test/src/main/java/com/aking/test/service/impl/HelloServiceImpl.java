package com.aking.test.service.impl;

import com.aking.test.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/9/10 18:02
 * @Version 1.0
 **/
@Service
public class HelloServiceImpl implements HelloService {
    /**
     * hello
     *
     * @param name
     */
    @Override
    public Boolean sayHello(String name) {
        System.out.println(String.format("hello:%s", name));
        return Boolean.TRUE;
    }
}
