package com.aking.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Y10003453
 */
@SpringBootApplication
@EnableAsync //开启spring事件异步设置，加@Async注解
public class DesignApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);
    }
}