package com.aking.wx.controller;

import com.aking.pojo.Template;
import com.aking.wx.service.MyWxService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ActivityController
 * @Description
 * @Author yk
 * @Date 2020/5/22 18:39
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private MyWxService myWxService;

    /**
     * 微信模板发送
     * @param template
     * @return
     */
    @PostMapping("/templateSend.do")
    public String templateSend(@RequestBody Template template) {
        return new Gson().toJson(myWxService.templateSend(template));
    }
}
