package com.aking.controller;

import com.aking.domain.Activity;
import com.aking.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class HelloController {
    @Autowired
    private ActivityService activityService;

    /**
     * 查找所有活动list
     * @return
     */
    @GetMapping("/findActivityList.do")
    public List<Activity> findActivityList(){
        Activity activity = new Activity();
        activity.setBrands("西门子");
        return activityService.findActivityList();
    }
}
