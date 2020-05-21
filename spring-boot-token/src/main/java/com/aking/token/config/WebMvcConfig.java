package com.aking.token.config;

import com.aking.token.resolver.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @ClassName WebMvcConfig
 * @Description
 * @Author yk
 * @Date 2020/5/19 19:04
 * @Version 1.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userResolver());
    }

    @Bean
    public CurrentUserMethodArgumentResolver userResolver() {
        return new CurrentUserMethodArgumentResolver();
    }
}
