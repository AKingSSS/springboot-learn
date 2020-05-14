package com.aking.controller;

import com.aking.annotations.WebLog;
import com.aking.domain.Activity;
import com.aking.service.ActivityService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @WebLog(resultRequired = false)
    public List<Activity> findActivityList(@RequestParam("brandName") String brandName) {
        List<Activity> activityList = new ArrayList<>();
        Activity activity = new Activity();
        activity.setBrands(brandName);
        try {
            activityList = activityService.findActivityList();
//            int i = 1 / 0;
        } catch (Exception e) {
/*            //错误
            log.error("findActivityList msg = {}", e.getMessage());*/
            //正确
            log.error("findActivityList msg = {}", e);
        }
        return activityList;
    }
}
