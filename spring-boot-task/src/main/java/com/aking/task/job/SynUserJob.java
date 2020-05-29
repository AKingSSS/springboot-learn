package com.aking.task.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @ClassName SynUserJob
 * @Description
 * @Author yk
 * @Date 2020/5/29 16:13
 * @Version 1.0
 **/
@Component
@Slf4j
public class SynUserJob {
    /**
     * 表示方法执行完成后 5 秒
     *
     * @throws InterruptedException
     */
    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() throws InterruptedException {
        log.info("fixedDelay 每隔5秒, now = [{}]", LocalDate.now());
    }

    /**
     * 表示每隔 3 秒
     */
    @Scheduled(fixedRate = 3000)
    public void fixedRateJob() {

        log.info("fixedRate 每隔3秒, now = [{}]", LocalDate.now());
    }

    /**
     * 表示每天 8 时 30分 0 秒执行
     */
    @Scheduled(cron = "0 0,02 0,17 ? * ? ")
    public void cronJob() {
        log.info(" now = [{}]...>>cron....", LocalDate.now());
    }
}
