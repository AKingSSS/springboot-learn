package com.aking.jdbc.pool;

import com.aking.jdbc.pool.config.DbConfig;

import java.sql.Connection;

/**
 * @ClassName ConnectionPoolManager
 * @Description 创建数据库连接池管理器，方便管理
 * @Author yk
 * @Date 2020/9/4 15:40
 * @Version 1.0
 **/
public class ConnectionPoolManager {
    private static DbConfig dbConfig = new DbConfig();
    private static ConnectionPool connectionPool = new ConnectionPool(dbConfig);

    /**
     * 获取连接(重复利用机制)
     * @return
     */
    public static Connection getConnection() {
        return connectionPool.getConnection();
    }

    /**
     * 释放连接(可回收机制)
     * @param connection
     */
    public static void releaseConnection(Connection connection) {
        connectionPool.releaseConnection(connection);
    }
}
