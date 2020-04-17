package com.aking.zookeeper.lock;

import org.apache.zookeeper.KeeperException;

/**
 * @ClassName TicketSeller
 * @Description
 * @Author yangkang
 * @Date 2020/4/16 22:05
 * @Version 1.0
 **/
public class TicketSeller {
    private void sell() {
        System.out.println("售票开始");
        // 模拟费时操作
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("售票结束");
    }


    /**
     * 获取锁买票
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void sellTickWithLock() throws KeeperException, InterruptedException {
        MyLock lock = new MyLock();
        // 获取锁
        lock.acquireLock();
        sell();
        // 释放锁
        lock.releaseLock();
    }

    public static void main(String[] args) {
        TicketSeller ticketSeller = new TicketSeller();
        for (int i = 0; i < 10; i++) {
            try {
                ticketSeller.sellTickWithLock();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
