package com.aking.ioc;

import com.aking.ioc.service.ActivityService;
import com.aking.ioc.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IocApplicationTests {
/*    @Autowired
    @Qualifier("activityService")
    private ActivityService activityService;*/

    @Autowired
    @Qualifier("lotteryActivityService")
    private ActivityService activityService;

    @Resource
    private HelloService helloService;

    @Test
    public void join() {
        activityService.join();
    }

    @Test
    public void say() {
        helloService.say();
    }

}
