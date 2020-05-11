package com.aking.service;

import com.aking.domain.Activity;

import java.util.List;

/**
 * @ClassName ActivityService
 * @Description
 * @Author yk
 * @Date 2020/5/8 19:47
 * @Version 1.0
 **/
public interface ActivityService {
    /**
     * 查询用户列表
     * @return
     */
    List<Activity> findActivityList();
}
