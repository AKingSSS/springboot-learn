package com.aking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Y10003453
 */
@SpringBootApplication
@MapperScan("com.aking.manager")
public class MysqlWarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MysqlWarApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        // 这里可以加载自定义配置文件
        return builder.sources(MysqlWarApplication.class);
    }
}