package com.aking.shiro.service;

import com.aking.shiro.pojo.User;

/**
 * @ClassName LoginService
 * @Description
 * @Author yangkang
 * @Date 2020/7/1 15:15
 * @Version 1.0
 **/
public interface LoginService {
    /**
     * 根据姓名获取用户信息
     * @param getMapByName
     * @return
     */
    public User getUserByName(String getMapByName);
}
