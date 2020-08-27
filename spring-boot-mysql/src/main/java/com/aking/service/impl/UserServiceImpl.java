package com.aking.service.impl;

import com.aking.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/8/27 18:14
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    /**
     * 保存用户
     *
     * @return
     */
    @Override
    public Boolean saveUser() {
        return null;
    }

    /**
     * 删除用户
     *
     * @return
     */
    @Override
    @Deprecated
    public Boolean delUser() {
        return null;
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.delUser();
        userService.saveUser();
    }
}
