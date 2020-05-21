package com.aking.redis.controller;

import com.aking.redis.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AsyncController
 * @Description TODO
 * @Author aking
 * @Date 2020/5/21 23:49
 * @Version 1.0
 **/
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async.do")
    public void async(){
        for (int i = 0; i < 10; i++) {
            asyncService.executeAsync();
        }

    }
}
