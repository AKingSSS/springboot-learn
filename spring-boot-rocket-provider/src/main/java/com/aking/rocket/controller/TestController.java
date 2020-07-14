package com.aking.rocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author yk
 * @Date 2020/7/14 16:34
 * @Version 1.0
 **/
@RestController
@RequestMapping("/rocket")
@Slf4j
public class TestController {
    private static String TOPIC = "DemoTopic";
    private static String TAGS = "Python大星Tags";

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @RequestMapping("send")
    public String test() throws Throwable {
        Message msg = new Message(TOPIC, TAGS,
                ("Say Hello RocketMQ to Python大星").getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 调用客户端发送消息
        SendResult sendResult = defaultMQProducer.send(msg);
        log.info("sendResult: {}.", sendResult);
        return "SUCCESS";
    }
}
