package com.aking.ioc.bean;

import com.aking.ioc.service.ActivityService;
import com.aking.ioc.service.impl.LotteryActivityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AppConfig
 * @Description 通过 @Bean 注解生成 bean
 * @Author yk
 * @Date 2020/4/29 15:18
 * @Version 1.0
 **/
@Configuration
public class AppConfig {

    @Bean("lotteryService")
    public ActivityService getLotteryService() {
        return new LotteryActivityServiceImpl();
    }

}
