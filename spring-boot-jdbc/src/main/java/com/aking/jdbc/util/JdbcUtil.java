package com.aking.jdbc.util;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JdbcUtil
 * @Description
 * @Author yk
 * @Date 2020/9/2 16:14
 * @Version 1.0
 **/
@Slf4j
public class JdbcUtil {
    /**
     * 定义全局变量
     */
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driverClass = null;

    /**
     * 读取配置文件内容,放在静态代码块中就行,因为只需要加载一次就可以了
     */
    static {
        try {
            Properties props = new Properties();
            //使用类路径加载的方式读取配置文件
            //读取的文件路径要以“/”开头,使用"/"开头会直接定位到工程的src路径下
            InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");
            //加载配置文件
            props.load(in);
            //读取配置文件信息
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            driverClass = props.getProperty("driverClass");
            //动态注册mysql驱动程序
            Class.forName(driverClass);
            log.info("成功加载MySQL驱动程序");
        } catch (Exception e) {
            log.error("mysql 驱动程序注册失败 exception error:[{}]", e);
        }
    }

    /**
     * 获取连接对象Connection
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            //要连接数据库,需要向java.sql.DriverManager请求并获得Connection对象
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error("DriverManager.getConnection exception error:[{}]", e);
            //抛出运行时异常
            throw new RuntimeException();
        }
    }

    /**
     * 关闭连接的方法，后打开的先关闭
     *
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        //关闭ResultSet对象
        if (rs != null) {
            try {
                //关闭rs，设置rs=null，因为java会优先回收值为null的变量
                rs.close();
                rs = null;
            } catch (SQLException e) {
                log.error("rs.close exception error:[{}]", e);
                throw new RuntimeException();
            }
        }
        //关闭Statement对象,因为PrepareStatement和CallableStatement都是Statement的子接口，所以这里只需要有关闭Statement对象的方法就可以了
        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (SQLException e) {
                log.error("stmt.close exception error:[{}]", e);
                throw new RuntimeException();
            }
        }
        //关闭Connection对象
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                log.error("conn.close exception error:[{}]", e);
                throw new RuntimeException();
            }
        }
    }
}
