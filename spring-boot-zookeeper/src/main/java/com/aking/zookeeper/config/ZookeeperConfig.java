package com.aking.zookeeper.config;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZookeeperConfig
 * @Description
 * @Author yangkang
 * @Date 2020/4/14 9:38
 * @Version 1.0
 **/
@Configuration
@PropertySource(value = "classpath:application.properties",encoding = "utf-8")
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperConfig {
    private static final Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);

    private String address;
    private int timeout;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Bean(name="zkClient")
    public ZooKeeper zkClient() {
        ZooKeeper zooKeeper=null;
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            // 连接成功后，会回调watcher监听，此连接操作是异步的，执行完new语句后，直接调用后续代码
            // 可指定多台服务地址 127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
            zooKeeper = new ZooKeeper(address, timeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if(Event.KeeperState.SyncConnected==event.getState()){
                        //如果收到了服务端的响应事件,连接成功
                        System.out.println("连接成功");
                        countDownLatch.countDown();
                    }
                    System.out.println("path = " + event.getPath());
                    System.out.println("eventType = " + event.getType());

                }
            });
            countDownLatch.await();
            logger.info("【初始化ZooKeeper连接状态....】= " + zooKeeper.getState());

        }catch (Exception e){
            logger.error("初始化ZooKeeper连接异常....】={}",e);
        }
        return zooKeeper;
    }
}
