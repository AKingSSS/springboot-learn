package com.aking.jdbc.pool.config;

import lombok.Data;

/**
 * @ClassName DbConfig
 * @Description
 * @Author yk
 * @Date 2020/9/4 15:12
 * @Version 1.0
 **/
@Data
public class DbConfig {
    private String driverName = "com.mysql.jdbc.Driver";

    private String url = "jdbc:mysql://localhost:3306/platform_admin?useUnicode=true&characterEncoding=UTF-8";

    private String userName = "root";

    private String password = "123456";

    private String poolName = "DbBeanPool";
    /**
     * 空闲池，最小连接数
     */
    private int minConnections = 1;
    /**
     * 空闲池，最大连接数
     */
    private int maxConnections = 10;
    /**
     * 初始化连接数
     */
    private int initConnections = 5;
    /**
     * 重复获得连接的频率
     */
    private long waitTimeOut = 1000;
    /**
     * 最大允许的连接数，和数据库对应
     */
    private int maxActiveConnections = 10;
    /**
     * 连接超时时间，默认20分钟
     */
    private long connectionTimeOut = 1000 * 60 * 20;
}
