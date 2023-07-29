package com.lingnan.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JdbcUtil {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        // 读取资源文件,获取值
        // 创建properties集合类
        Properties properties = new Properties();
        try {
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 使用properties对象加载输入流
            properties.load(inputStream);

            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     *
     * @return 连接对象
     */

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /***
     * DML操作（增删改） 1.获取连接数据库对象 2.预处理 3.执行更新操作
     *
     * @param sql
     * @param obj
     */
    // 调用者只需传入一个sql语句，和一个Object数组。该数组存储的是SQL语句中的占位符
    public static boolean executeUpdate(String sql, Object... obj) {

        Connection con = null;
        try {
            con = getConnection(); // 调用getConnection()方法连接数据库
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);// 预处理

            for (int i = 0; i < obj.length; i++) {// 预处理声明占位符
                ps.setObject(i + 1, obj[i]);
            }
            int count = ps.executeUpdate();// 执行更新操作

            if(count > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            close(null, ps, con);// 调用close()方法关闭资源
        }
        return false;
    }

    /***
     * DQL查询 Result获取数据集
     *
     * @param sql
     * @param obj
     * @return
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... obj) {
        Connection con = null;
        try {
            con = getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            rs = ps.executeQuery();

            // new 一个空的list集合用来存放查询结果
            List<Map<String, Object>> list = new ArrayList<>();

            // 获取结果集的列数
            int count = rs.getMetaData().getColumnCount();

            // 对结果集遍历每一条数据是一个Map集合，列是key,值是value
            while (rs.next()) {
                // 一个空的map集合，用来存放每一行数据
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 0; i < count; i++) {
                    Object ob = rs.getObject(i + 1);// 获取值
                    String key = rs.getMetaData().getColumnName(i + 1);// 获取k即列名
                    map.put(key, ob);
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            close(rs, ps, con);
        }

        return null;

    }

    /**
     * 释放资源
     *
     * @param rs
     * @param ps
     * @param conn
     */
    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
