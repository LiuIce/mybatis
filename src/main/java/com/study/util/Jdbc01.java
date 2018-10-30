package com.study.util;


import com.study.util.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title:study-mybatis
 * @Description:
 * @Author: Lh
 * @Date: Created in 10:20 2018/10/30
 * @Version:1.0
 */
public class Jdbc01 {
    private static final Logger log = LoggerFactory.getLogger(Jdbc01.class);
    public static void main(String[] args) {
        Jdbc01 jdbc01 = new Jdbc01();
        //jdbc01.insert("张三", "123456");

        User u= new User();
       /* u.setUsername("wangwu");
        u.setPassword("00000");
        jdbc01.insert(u);*/

        u=jdbc01.query(2);
        log.info("userid:{},usernmae:{}",u.getId(),u.getUsername());

    }

    public static void insert(String name, String password) {
        String sql = "insert into user (username,password) value(?,?)";
        Connection connection = DbUtil.open();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(connection);
        }
    }


    public static void insert(User user) {
        String sql = "insert into user (username,password) value(?,?)";
        Connection connection = DbUtil.open();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(connection);
        }
    }

    public static User query(int id) {
        String sql = "select id,username,password from User where id =?";
        Connection connection = DbUtil.open();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rest = preparedStatement.executeQuery();
            if (rest.next()) {
                String name = rest.getString(2);
                User user = new User();
                user.setId(id);
                user.setUsername(name);
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(connection);
        }
        return null;
    }
}

