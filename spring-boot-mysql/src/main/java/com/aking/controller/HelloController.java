package com.aking.controller;

import com.aking.domain.Activity;
import com.aking.service.ActivityService;
import com.aking.service.impl.ActivityServiceImpl;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description
 * @Author yk
 * @Date 2020/5/7 15:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class HelloController {
    @Autowired
    private ActivityService activityService;

    /**
     * 查找所有活动list
     *
     * @return
     */
    @GetMapping("/findActivityList.do")
    public List<Activity> findActivityList() {
        List<Activity> activityList = new ArrayList<>();
        log.info("this method is {} ", "findActivityList");
        Activity activity = new Activity();
        activity.setBrands("西门子");
        try {
            activityList = activityService.findActivityList();
            log.info("activityList = {}", JSONObject.toJSONString(activityList));
            int i = 1 / 0;
        } catch (Exception e) {
            //错误
            log.error("findActivityList msg = {}", e.getMessage());
            //正确
            log.error("findActivityList msg = {}", e);
        }
        return activityList;
    }
}
