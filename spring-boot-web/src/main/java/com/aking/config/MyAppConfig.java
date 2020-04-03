package com.aking.config;

import com.aking.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyAppConfig
 * @Description
 * @Author yangkang
 * @Date 2020/4/3 0:32
 * @Version 1.0
 **/
@Configuration
public class MyAppConfig {
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
