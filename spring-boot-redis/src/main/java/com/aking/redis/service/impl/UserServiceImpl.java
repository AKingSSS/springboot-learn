package com.aking.redis.service.impl;

import com.aking.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author aking
 * @Date 2020/5/21 23:46
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 执行异步任务
     * 可以根据需求，自己加参数拟定，我这里就做个测试演示
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");
        try {
            // 用户业务处理
            Thread.sleep(1000);
        } catch (Exception e) {
            log.info("业务异常: [{}]", e);
        }
        log.info("end executeAsync");
    }
}
