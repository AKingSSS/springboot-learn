package com.aking.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Y10003453
 */
@SpringBootApplication
public class MongodbApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }
}