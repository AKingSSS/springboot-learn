package com.aking.swagger;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SwaggereApplication
 * @Description
 * @Author yk
 * @Date 2020/6/9 15:43
 * @Version 1.0
 **/
@SpringBootApplication
@EnableSwagger2Doc
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }
}
