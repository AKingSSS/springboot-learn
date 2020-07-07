package com.aking.kafka.config;

import org.springframework.kafka.core.KafkaTemplate;

/**
 * @ClassName KafkaSender
 * @Description
 * @Author yk
 * @Date 2020/7/7 16:31
 * @Version 1.0
 **/
public class KafkaSender {
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * send message
     */
    public void sendMessage(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message);
    }
}
