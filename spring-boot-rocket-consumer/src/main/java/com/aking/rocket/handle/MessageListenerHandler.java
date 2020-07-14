package com.aking.rocket.handle;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MessageListenerHandler
 * @Description
 * @Author yk
 * @Date 2020/7/14 16:31
 * @Version 1.0
 **/
@Component
@Slf4j
public class MessageListenerHandler implements MessageListenerConcurrently {

    private static String TOPIC = "DemoTopic";
    private static String TAGS = "Python大星Tags";
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                    ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        if (CollectionUtils.isEmpty(msgs)) {
            log.info("receive blank msgs...");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);
        String msg = new String(messageExt.getBody());
        if (messageExt.getTopic().equals(TOPIC)) {
            if (messageExt.getTags().equals(TAGS)){
                //TODO 判断该消息是否重复消费（RocketMQ不保证消息不重复，
                // 如果你的业务需要保证严格的不重复消息，需要你自己在业务端去重）
                //TODO 获取该消息重试次数
                int reconsume = messageExt.getReconsumeTimes();
                //消息已经重试了3次，如果不需要再次消费，则返回成功
                if (reconsume == 3) {
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                //TODO 处理对应的业务逻辑
                // mock 消费逻辑
                mockConsume(msg);
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
    private void mockConsume(String msg){
        log.info("receive msg: {}.", msg);
    }
}
