package org.lanqiao.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 * 数据库连接池
 * 数据库的连接
 * 数据库资源的关闭
 * 数据库查询的方法封装
 * 数据库增删改的方法的封装
 */
public class JDBCUtil {
    private static Connection conn;
    private static PreparedStatement pst;
    private static ResultSet rs;


    //数据库连接池连接
    //静态代码块 不需要调用   会随查询运行而运行
    static {
        try {
            //创建一个配置文件类
            Properties properties = new Properties();
            //读取druid.properties文件
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            //使用alibab数据库连接池创建dataSource
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //获取连接
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 查询功能
    public static ResultSet exeQuery(String sql, Object[] obj) {
        try {
            // 预编译sq1
            pst = conn.prepareStatement(sql);

            if (obj != null) {
                // 循环给?赋值
                for (int i = 1; i <= obj.length; i++) {
                    pst.setObject(i, obj[i - 1]);
                }
            }
            // 执行sql
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 增删改方法
    public static int exeChange(String sql, Object[] obj) {
        int j = 0;
        try {
            // 预编译sql
            pst = conn.prepareStatement(sql);
            if (obj != null) {
                // 循环给?赋值
                for (int i = 1; i <= obj.length; i++) {
                    pst.setObject(i, obj[i - 1]);
                }
            }
            //执行sql
            j = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return j;

    }


}
