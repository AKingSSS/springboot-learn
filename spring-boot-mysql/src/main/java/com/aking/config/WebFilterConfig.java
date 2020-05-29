package com.aking.config;

import com.aking.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName WebFilterConfig
 * @Description
 * @Author yk
 * @Date 2020/5/29 15:19
 * @Version 1.0
 **/
@Configuration
public class WebFilterConfig {

    @Bean
    public FilterRegistrationBean thirdFilter() {
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        List<String> urls = new LinkedList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
