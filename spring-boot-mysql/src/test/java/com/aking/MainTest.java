package com.aking;

import com.aking.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName MainTest
 * @Description
 * @Author yk
 * @Date 2020/6/2 16:02
 * @Version 1.0
 **/

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
//classes指定springboot的启动类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MysqlWarApplication.class)
public class MainTest {
    @Autowired
    @Qualifier("activityService2")
    private ActivityService activityService;

    @Test
    public void aServiceTest() {
        log.info("开始测试 activityService 逻辑 start");
        activityService.findActivityList();
        log.info("开始测试 activityService 逻辑 end");
    }
}