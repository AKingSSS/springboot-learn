package com.aking.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName Girl
 * @Description
 * @Author yangkang
 * @Date 2020/4/2 23:17
 * @Version 1.0
 **/
@Component
@PropertySource(value = {"classpath:local.properties"})
@ConfigurationProperties(prefix = "girl")
public class Girl {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "school='" + school + '\'' +
                '}';
    }
}
