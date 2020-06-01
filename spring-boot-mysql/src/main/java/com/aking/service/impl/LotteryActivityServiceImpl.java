package com.aking.service.impl;

import com.aking.domain.Activity;
import com.aking.manager.ActivityDao;
import com.aking.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ActivityServiceImpl
 * @Description
 * @Author yk
 * @Date 2020/5/8 19:47
 * @Version 1.0
 **/
@Service("lotteryActivityService")
@Slf4j
public class LotteryActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    /**
     * 查询用户列表
     *
     * @return
     */
    @Override
    public List<Activity> findActivityList() {
        log.info("查询用户列表");
        return activityDao.findActivityList();
    }
}
