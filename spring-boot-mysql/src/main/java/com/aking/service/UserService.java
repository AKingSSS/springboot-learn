package com.aking.service;

/**
 * @ClassName UserService
 * @Description
 * @Author yk
 * @Date 2020/8/27 18:14
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 保存用户
     * @return
     */
    Boolean saveUser();

    /**
     * 删除用户
     * @return
     */
    @Deprecated
    Boolean delUser();
}
