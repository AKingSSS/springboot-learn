package com.aking.zookeeper.controller;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZkController
 * @Description
 * @Author yangkang
 * @Date 2020/4/13 22:40
 * @Version 1.0
 **/
@RestController
public class ZkController {
    @GetMapping(value = "/zkGet")
    public String zkGet() throws IOException, InterruptedException {
        // 计数器对象
        CountDownLatch countDownLatch = new CountDownLatch(1);
        /**
         *  arg1:服务器的ip和端口
         *  arg2:客户端与服务器之间的会话超时时间 以毫秒为单位
         *  arg3:监视器对象
         */
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接创建成功！");
                    countDownLatch.countDown();
                }
            }
        });
        // 主线程阻塞等待连接对象的创建
        countDownLatch.await();
        // 会话id
        System.out.println("会话 id = " + zk.getSessionId());
        zk.close();
        return "success";
    }
}
