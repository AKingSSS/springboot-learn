package com.aking;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Y10003453
 */
@SpringBootApplication
@EnableDubbo
public class ExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelApplication.class, args);
    }

}
