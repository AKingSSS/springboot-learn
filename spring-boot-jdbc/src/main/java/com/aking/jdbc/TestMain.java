package com.aking.jdbc;

import com.aking.jdbc.util.JdbcUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @ClassName TestMain
 * @Description
 * @Author yk
 * @Date 2020/9/2 16:38
 * @Version 1.0
 **/
@Slf4j
public class TestMain {
    public static void main(String[] args) {
        // 连接数据库
        Connection conn = JdbcUtil.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM owner");
            while (rs.next()) {
                String mobile = rs.getNString("mobile");
                log.info("mobile = " + mobile);
            }
        } catch (Exception e) {
            log.error("exception error:[{}]", e);
        } finally {
            //关闭顺序1、关闭记录集,2、关闭声明,3、关闭连接对象
            JdbcUtil.close(conn, stmt, rs);
        }
    }
}
