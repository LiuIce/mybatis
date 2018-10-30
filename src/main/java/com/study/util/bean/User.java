package com.study.util.bean;

/**
 * @Title:study-mybatis
 * @Description:
 * @Author: Lh
 * @Date: Created in 10:14 2018/10/30
 * @Version:1.0
 */
public class User {
   private  int id;
   private String username;
   private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
