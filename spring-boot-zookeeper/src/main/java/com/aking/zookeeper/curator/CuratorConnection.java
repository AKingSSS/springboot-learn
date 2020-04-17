package com.aking.zookeeper.curator;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.retry.RetryUntilElapsed;

/**
 * @ClassName CuratorConnection
 * @Description
 * @Author yangkang
 * @Date 2020/4/17 9:45
 * @Version 1.0
 **/
public class CuratorConnection {
    public static void main(String[] args) {
        // session 重连策略
        /**
         * 3 s 后重连一次，只重连1次
         */
        RetryPolicy retryPolicy1 = new RetryOneTime(3000);
        /**
         * 每 3 s 重连一次，重连 3 次
         */
        RetryPolicy retryPolicy2 = new RetryNTimes(3000,3);
        /**
         * 每 3 s 重连一次，总等待时间超过 10 s后停止重连
         */
        RetryPolicy retryPolicy3 = new RetryUntilElapsed(10000, 3000);

        RetryPolicy retryPolicy4 = new ExponentialBackoffRetry(1000,3);

        // 创建连接对象
        CuratorFramework client = CuratorFrameworkFactory.builder()
                // IP地址和端口号 (集群多个逗号分隔)
                .connectString("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183")
                // 会话超时时间设置 5 s
                .sessionTimeoutMs(5000)
                // 超时处理策略：3s一次重连
                .retryPolicy(retryPolicy4)
                // 命名空间
                .namespace("create")
                // 构建连接状态
                .build();

        // 打开连接
        client.start();
        System.out.println("==============>" + client.isStarted());
        // 关闭连接
        client.close();
    }
}
