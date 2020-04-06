package com.aking.dubbo.provider.service.impl;

import com.aking.dubbo.api.service.HelloService;
import com.alibaba.dubbo.config.annotation.Service;


/**
 * @ClassName HelloServiceImpl
 * @Description
 * @Author yangkang
 * @Date 2020/4/6 10:25
 * @Version 1.0
 **/
@Service(version = "${dubbo.service.version}")
public class HelloServiceImpl implements HelloService {
    /**
     * 输出 hello
     *
     * @param name
     * @return
     */
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
