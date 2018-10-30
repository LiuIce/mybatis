package com.study.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Title:study-mybatis
 * @Description:
 * @Author: Lh
 * @Date: Created in 17:00 2018/10/29
 * @Version:1.0
 */
public class DbUtil {

    private static String driver;
    private static String username;
    private static  String password;
    private static  String url;


    static {
        driver="com.mysql.jdbc.Driver";//需要的数据库驱动
        url="jdbc:mysql://localhost:3306/test";//数据库名路径
        username="root";
        password="root";
    }

    public static Connection open()
    {
        try {
            Class.forName(driver);
            return (Connection) DriverManager.getConnection(url,username, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }//加载驱动

        return null;
    }

    /*
     * 关闭数据库
     */
    public static void close(Connection conn)
    {
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
