package com.aking.jdbc.pool;

import java.sql.Connection;

/**
 * @ClassName PoolTest
 * @Description
 * @Author yk
 * @Date 2020/9/4 15:43
 * @Version 1.0
 **/
public class PoolTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        Connection connection = ConnectionPoolManager.getConnection();
                        System.out.println(Thread.currentThread().getName() + ",connection:" + connection);
                        ConnectionPoolManager.releaseConnection(connection);
                    }

                }
            }, "线程" + i).start();
        }
    }
}
