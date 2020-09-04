package com.aking.jdbc.pool;

import com.aking.jdbc.pool.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * @ClassName ConnectionPool
 * @Description
 * @Author yk
 * @Date 2020/9/4 15:19
 * @Version 1.0
 **/
public class ConnectionPool {
    /**
     * 使用线程安全的集合 空闲线程 容器 没有被使用的连接存放
     */
    private List<Connection> freeConnection = new Vector<Connection>();
    /**
     * 使用线程安全的集合 活动线程 容器 容器正在使用的连接
     */
    private List<Connection> activeConnection = new Vector<Connection>();
    private DbConfig dbConfig;

    private volatile int connNum = 0;

    /**
     * 通过构造函数初始化连接池
     *
     * @param dbConfig
     */
    public ConnectionPool(DbConfig dbConfig) {
        //获取配置文件信息
        this.dbConfig = dbConfig;
        //1.初始化连接池
        for (int i = 0; i < dbConfig.getInitConnections(); i++) {
            Connection connection = newConnect();
            if (connection != null) {
                //放到空闲连接池中
                freeConnection.add(connection);
            }
        }
    }


    /**
     * 2、创建连接
     *
     * @return
     */
    private synchronized Connection newConnect() {
        Connection connection = null;
        try {
            Class.forName(dbConfig.getDriverName());
            connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(), dbConfig.getPassword());
            //记录连接数
            connNum++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }

    /**
     * 3、获取连接
     *
     * @return
     */
    public synchronized Connection getConnection() {
        Connection connection = null;
        //判断是否小于最大活动连接数
        if (connNum <= dbConfig.getMaxActiveConnections()) {
            //判断空闲连接池是否存有连接
            if (freeConnection.size() > 0) {
                //空闲连接池删除
                connection = freeConnection.remove(0);
            } else {
                //创建新的连接
                connection = newConnect();
            }
            //如果连接池可用
            if (isAvailable(connection)) {
                //放到活动连接池中
                activeConnection.add(connection);
            } else {
                //连接已失效
                connNum--;
                //重复调用
                connection = getConnection();
            }
        } else {
            // 大于最大活动连接数，进行等待
            try {
                wait(dbConfig.getConnectionTimeOut());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 重试
            connection = getConnection();
        }
        return connection;
    }

    /**
     * 4.释放连接 回收
     * 判断连接是否可用
     * ==>判断空闲线程是否已满
     * 没满==》回收连接，放到空闲线程池中
     * 已满==》关闭连接
     * 活动连接池移除该连接
     */
    public synchronized void releaseConnection(Connection connection) {
        //判断连接是否可用
        if (isAvailable(connection)) {
            //判断空闲线程是否没满
            if (freeConnection.size() < dbConfig.getMaxConnections()) {
                freeConnection.add(connection);
            } else {
                // 空闲线程已经满
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //活动连接池移除该连接
            activeConnection.remove(connection);
            //连接数减一
            connNum--;
            notifyAll();
        }
    }

    /***
     * 连接是否可用
     * @param connection
     * @return
     */
    public boolean isAvailable(Connection connection) {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;
    }
}

