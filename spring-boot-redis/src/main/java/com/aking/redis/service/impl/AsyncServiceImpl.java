package com.aking.redis.service.impl;

import com.aking.redis.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName AsyncService
 * @Description
 * @Author aking
 * @Date 2020/5/21 23:46
 * @Version 1.0
 **/
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {
    /**
     * 执行异步任务
     * 可以根据需求，自己加参数拟定，我这里就做个测试演示
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");

        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");

        log.info("end executeAsync");
    }
}
