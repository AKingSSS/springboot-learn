package com.aking.shiro.controller;

import com.aking.annotations.LoginRequired;
import com.aking.annotations.WebLog;
import com.aking.domain.Activity;
import com.aking.service.ActivityService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @Qualifier("activityService1")
    private ActivityService activityService;
/*
    // setter 注入
    private ActivityService activityService;
    //    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
*/

/*
        // 构造器注入
    private final ActivityService activityService;

    public HelloController(ActivityService activityService) {
        this.activityService = activityService;
    }
*/

    /**
     * 查找所有活动list
     *
     * @return
     */
    @GetMapping(value = "/findActivityList.do")
    @WebLog
    @LoginRequired(loginRequired = false)
    public PageInfo findActivityList(@RequestParam("brandName") String brandName) {
        PageInfo pageInfo = new PageInfo<>();
        Activity activity = new Activity();
        activity.setBrands(brandName);
        try {
            pageInfo = activityService.findActivityList();
//            int i = 1 / 0;
        } catch (Exception e) {
/*            //错误
            log.error("findActivityList msg = {}", e.getMessage());*/
            //正确
            log.error("findActivityList msg = {}", e);
        }
        return pageInfo;
    }
}
