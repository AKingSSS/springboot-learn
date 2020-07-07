package com.aking.kafka.controller;

import com.aking.kafka.config.KafkaSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description
 * @Author yk
 * @Date 2020/7/7 16:37
 * @Version 1.0
 **/
@RestController
@RequestMapping("/provider")
@Slf4j
public class ProviderController {
    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("/send")
    public Object send(String msg) {
        try {
            kafkaSender.sendMessage("ykTopic", "name", msg);
        } catch (Exception e) {
            log.error("send error: [{}]", e);
            return "send fail";
        }
        return "send ok";

    }
}
