package com.aking.zookeeper.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZkWatcher
 * @Description
 * @Author yangkang
 * @Date 2020/4/16 11:04
 * @Version 1.0
 **/
public class ZkWatcher implements Watcher {
    /**
     * 计数器对象
     */
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    static ZooKeeper zooKeeper;


    @Override
    public void process(WatchedEvent event) {
        try {
            System.out.println("自定义watcher");
            System.out.println("path = " + event.getPath());
            System.out.println("eventType = " + event.getType());
            if (event.getType() == Event.EventType.None) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接创建成功");
                    countDownLatch.countDown();
                } else if(event.getState() == Event.KeeperState.Disconnected) {
                    System.out.println("断开连接");
                    // 断开处理
                    System.out.println("短信提醒");
                } else if (event.getState() == Event.KeeperState.Expired) {
                    System.out.println("会话超时");
                    // 重新连接
                    zooKeeper = new ZooKeeper("127.0.0.1:2181",5000,new ZkWatcher());
                } else if(event.getState() == Event.KeeperState.AuthFailed) {
                    System.out.println("认证失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            zooKeeper = new ZooKeeper("127.0.0.1:2181",5000,new ZkWatcher());
            // 阻塞线程，等待连接的创建
            countDownLatch.await();
            //打印会话id
            System.out.println(zooKeeper.getSessionId());
            Thread.sleep(50000);
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
