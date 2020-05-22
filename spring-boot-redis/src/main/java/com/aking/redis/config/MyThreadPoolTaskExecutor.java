package com.aking.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName MyThreadPoolTaskExecutor
 * @Description
 * @Author yk
 * @Date 2020/5/22 11:06
 * @Version 1.0
 **/
@Slf4j
public class MyThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
    private void showThreadPoolInfo() {
        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();

        if (null == threadPoolExecutor) {
            return;
        }

        log.info("taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                threadPoolExecutor.getTaskCount(),
                threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getQueue().size());
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        showThreadPoolInfo();
        return super.submit(task);
    }
}
