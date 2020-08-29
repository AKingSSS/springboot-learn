package com.aking.rocket.controller;

import com.aking.rocket.util.ListSplitter;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aking.rocket.vo.Order;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private TransactionMQProducer transactionMQProducer;

    /**
     * 同步发送
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendSync")
    public String sendSync() throws Throwable {
        Message msg = new Message(TOPIC, TAGS,
                ("Say Hello RocketMQ to Python大星").getBytes(RemotingHelper.DEFAULT_CHARSET));
        //用于消息筛选
        msg.putUserProperty("a","13");
        // 调用客户端发送消息
        SendResult sendResult = defaultMQProducer.send(msg);
        log.info("sendSync sendResult: [{}]", sendResult);
        return "SUCCESS";
    }

    /**
     * 延迟发送
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendDelaySync")
    public String sendDelaySync() throws Throwable {
        Message msg = new Message(TOPIC, TAGS,
                ("Say Hello RocketMQ to Python大星").getBytes(RemotingHelper.DEFAULT_CHARSET));
        //延时等级在MessageStoreConfig中配置
        // private String messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
        //从1s到2h分别对应着等级1-18,消息中
        msg.setDelayTimeLevel(3);
        // 调用客户端发送消息
        SendResult sendResult = defaultMQProducer.send(msg);
        log.info("sendSync sendResult: [{}]", sendResult);
        return "SUCCESS";
    }

    /**
     * 异步发送
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendAsync")
    public String sendAsync() throws Throwable {
        Message msg = new Message(TOPIC, TAGS,
                ("Say Hello RocketMQ to Python大星").getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 调用客户端发送消息
        defaultMQProducer.send(msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("sendAsync sendResult: [{}]", sendResult);
            }

            @Override
            public void onException(Throwable e) {
                log.error("sendAsync error: [{}]", e);
            }
        });
        return "SUCCESS";
    }

    /**
     * 单向发送
     * 这种方式主要用在不特别关心发送结果的场景，例如日志发送
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendOneway")
    public String sendOneway() throws Throwable {
        Message msg = new Message(TOPIC, TAGS,
                ("Say Hello RocketMQ to Python大星").getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 调用客户端发送消息
        defaultMQProducer.sendOneway(msg);
        return "SUCCESS";
    }

    /**
     * 订单发送
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendOrder")
    public String sendOrder() throws Throwable {
        List<Order> orderList = Order.buildOders();
        // 调用客户端发送消息
        for (Order order : orderList) {
            String body = new Gson().toJson(order);
            Message msg = new Message(TOPIC, TAGS, order.getId().toString(), body.getBytes("utf-8"));
            SendResult sendResult = defaultMQProducer.send(msg, new MessageQueueSelector() {
                /**
                 *
                 * @param mqs:队列集合
                 * @param ms：消息
                 * @param arg：业务标识参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message ms, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, order.getId());
            log.info("sendResult:[{}]", new Gson().toJson(sendResult));
        }
        return "SUCCESS";
    }

    /**
     * 批量发送
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendBatch")
    public String sendBatch() throws Throwable {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(TOPIC, TAGS,
                ("Python大星帅B！").getBytes(RemotingHelper.DEFAULT_CHARSET)));
        messages.add(new Message(TOPIC, TAGS,
                ("Python大星牛B！").getBytes(RemotingHelper.DEFAULT_CHARSET)));
        // 调用客户端发送消息
        try {
            SendResult sendResult = defaultMQProducer.send(messages);
            log.info("sendSync sendResult: [{}]", sendResult);
            return "SUCCESS";
        } catch (Exception e) {
            log.error("sendBatch error:[{}]", e);
            return "FAIL";
        }
    }

    /**
     * 批量发送
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendBatchBigData")
    public String sendBatchBigData() throws Throwable {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(TOPIC, TAGS,
                ("Python大星帅B！").getBytes(RemotingHelper.DEFAULT_CHARSET)));
        messages.add(new Message(TOPIC, TAGS,
                ("Python大星牛B！").getBytes(RemotingHelper.DEFAULT_CHARSET)));
        ListSplitter splitter = new ListSplitter(messages);
        while (splitter.hasNext()) {
            try {
                List<Message> listItem = splitter.next();
                SendResult sendResult = defaultMQProducer.send(messages);
                log.info("sendSync sendResult: [{}]", sendResult);
            } catch (Exception e) {
                //handle the error
                log.error("sendBatch error:[{}]", e);
                return "FAIL";
            }
        }
        return "SUCCESS";
    }

    /**
     * 发送事务消息
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("sendTransaction")
    public String sendTransaction() throws Throwable {
        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            try {
                Message msg =
                        new Message("TopicTest1234", tags[i % tags.length], "KEY" + i,
                                ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = transactionMQProducer.sendMessageInTransaction(msg, null);
                System.out.printf("%s%n", sendResult);

                Thread.sleep(10);
            } catch (MQClientException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100000; i++) {
            Thread.sleep(1000);
        }
        transactionMQProducer.shutdown();
        return "SUCCESS";
    }
}
