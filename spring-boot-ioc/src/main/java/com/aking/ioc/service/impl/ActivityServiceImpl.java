package com.aking.ioc.service.impl;

import com.aking.ioc.service.ActivityService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ActivityServiceImpl
 * @Description
 * @Author yangkang
 * @Date 2020/4/22 22:40
 * @Version 1.0
 **/
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    /**
     * 参加活动
     */
    @Override
    public void join() {
        System.out.println("参加促销活动");
    }
}
