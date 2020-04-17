package com.aking.zookeeper.config;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName CuratorZkConfig
 * @Description
 * @Author yangkang
 * @Date 2020/4/17 10:32
 * @Version 1.0
 **/
@Configuration
@PropertySource(value = "classpath:application.properties",encoding = "utf-8")
@ConfigurationProperties(prefix = "zk")
public class CuratorZkConfig {
    private static final Logger logger = LoggerFactory.getLogger(CuratorZkConfig.class);

    private String ip;
    private int timeout;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Bean(initMethod = "start")
    public CuratorFramework getCuratorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        // 创建连接对象
        CuratorFramework client = CuratorFrameworkFactory.builder()
                // IP地址和端口号 (集群多个逗号分隔)
                .connectString(ip)
                // 会话超时时间设置 5 s
                .sessionTimeoutMs(timeout)
                // 超时处理策略：3s一次重连
                .retryPolicy(retryPolicy)
                // 命名空间
                .namespace("create")
                // 构建连接状态
                .build();
        System.out.println("==============>" + client.isStarted());
        return client;
    }
}
