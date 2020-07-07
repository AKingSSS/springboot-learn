package com.aking.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @ClassName KafkaProducerAutoConfiguration
 * @Description
 * @Author yk
 * @Date 2020/7/7 16:31
 * @Version 1.0
 **/
@Configuration
public class KafkaProducerAutoConfiguration {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Bean
    public KafkaSender kafkaSender(){
        return new KafkaSender(kafkaTemplate);
    }
}
