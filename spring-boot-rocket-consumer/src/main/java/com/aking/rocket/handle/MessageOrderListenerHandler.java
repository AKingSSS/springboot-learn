package com.aking.rocket.handle;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MessageOrderListenerHandler
 * @Description
 * @Author yk
 * @Date 2020/8/25 17:11
 * @Version 1.0
 **/
@Component
@Slf4j
public class MessageOrderListenerHandler implements MessageListenerOrderly {
    private static String TOPIC = "DemoTopic";
    private static String TAGS = "Python大星Tags";

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs,
                                               ConsumeOrderlyContext consumeConcurrentlyContext) {
        if (CollectionUtils.isEmpty(msgs)) {
            log.info("receive blank msgs...");
            return ConsumeOrderlyStatus.SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);
        String msg = new String(messageExt.getBody());
        log.info("线程名称:[{}],msg:[{}]", Thread.currentThread().getName(), msg);
        if (messageExt.getTopic().equals(TOPIC)) {
            if (messageExt.getTags().equals(TAGS)) {
                //TODO 判断该消息是否重复消费（RocketMQ不保证消息不重复，
                // 如果你的业务需要保证严格的不重复消息，需要你自己在业务端去重）
                //TODO 获取该消息重试次数
                int reconsume = messageExt.getReconsumeTimes();
                //消息已经重试了3次，如果不需要再次消费，则返回成功
                if (reconsume == 3) {
                    return ConsumeOrderlyStatus.SUCCESS;
                }
                //TODO 处理对应的业务逻辑
                // mock 消费逻辑
                mockConsume(msg);
            }
        }
        return ConsumeOrderlyStatus.SUCCESS;
    }

    private void mockConsume(String msg) {
//        log.info("receive msg: {}.", msg);
    }


}
