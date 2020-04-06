package com.aking.dubbo.api.service;

/**
 * @ClassName HelloService
 * @Description
 * @Author yangkang
 * @Date 2020/4/6 10:20
 * @Version 1.0
 **/
public interface HelloService {
    /**
     * 输出 hello
     * @param name
     * @return
     */
    String sayHello(String name);
}
