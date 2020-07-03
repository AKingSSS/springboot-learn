package com.aking.dubbo.provider.service.impl;

import com.aking.dubbo.api.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/7/2 18:37
 * @Version 1.0
 **/
@Service(version = "${dubbo.service.version}")
public class UserServiceImpl implements UserService {
    /**
     * 输出 hello
     *
     * @param name
     * @return
     */
    @Override
    public String getUserInfo(String name) {
        return name;
    }
}
