package com.aking.zookeeper.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MyLock
 * @Description
 * @Author yangkang
 * @Date 2020/4/16 20:32
 * @Version 1.0
 **/
public class MyLock {
    /**
     * zk ip
     */
    String ip = "127.0.0.1:2181";
    /**
     * 计数器对象
     */
    CountDownLatch countDownLatch = new CountDownLatch(1);
    /**
     * zk配置信息
     */
    ZooKeeper zooKeeper;
    private static final String LOCK_ROOT_PATH = "/Locks";
    private static final String LOCK_ROOT_NAME = "Lock_";
    private String lockPath;

    /**
     * 打开 zk 连接
     */
    public MyLock() {
        try {
            zooKeeper = new ZooKeeper(ip, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.None) {
                        if (event.getState() == Event.KeeperState.SyncConnected) {
                            System.out.println("连接成功");
                            countDownLatch.countDown();
                        }
                    }
                }
            });
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 监视器对象，监视上一个节点的所有子节点
     */
    Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            if (event.getType() == Event.EventType.NodeDeleted) {
                synchronized (watcher) {

                }
            }
        }
    };

    /**
     * 获取锁
     */
    public void acquireLock() throws KeeperException, InterruptedException {
        //创建锁节点
        createLock();
        //尝试获取锁
        attemptLock();
    }

    /**
     * 创建节点
     *
     */
    private void createLock() throws KeeperException, InterruptedException {
        //判断locks节点是否存在，不存在创建
        Stat stat = zooKeeper.exists(LOCK_ROOT_PATH, false);
        if (stat == null) {
            zooKeeper.create(LOCK_ROOT_PATH, new byte[0],
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        //创建临时有序节点
        lockPath = zooKeeper.create(LOCK_ROOT_PATH + "/" + LOCK_ROOT_NAME, new byte[0],
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("节点创建成功" + lockPath);

    }


    /**
     * 尝试获取锁
     */
    private void attemptLock() throws KeeperException, InterruptedException {
        // 获取locks节点下的所有子节点
        List<String> list = zooKeeper.getChildren(LOCK_ROOT_PATH,false);
        Collections.sort(list);
        // /Locks/Lock_0000000001
        int index = list.indexOf(lockPath.substring(LOCK_ROOT_PATH.length() + 1));
        if (index == 0) {
            System.out.println("获取锁成功");
            return;
        } else {
            String path = list.get(index - 1);
            Stat stat = zooKeeper.exists(LOCK_ROOT_PATH + "/" + path, watcher);
            if (stat == null) {
                attemptLock();
            } else {
                synchronized (watcher) {
                    watcher.wait();
                }
            }
        }
    }

    /**
     * 释放锁
     */
    public void releaseLock() throws KeeperException, InterruptedException {
        // 删除临时有序节点
        zooKeeper.delete(this.lockPath,-1);
        zooKeeper.close();
        System.out.println("锁已经释放：" + this.lockPath);
    }


    public static void main(String[] args) {
        try {
            MyLock myLock = new MyLock();
            myLock.createLock();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
