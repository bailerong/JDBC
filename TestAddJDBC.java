package com.lele.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
* 这是一个关于我们的数据库的增加的程序
* */
public class TestAddJDBC {
    public static void main(String[] args) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection connection= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/memo?user=root&password=369888abc&useSSL=false");
                 //创建命令
                 Statement statement=connection.createStatement();){
                String sql=" insert into memo_group(id,name,created_time)values(2,'java组',now());";
                int effect = statement.executeUpdate
                        (sql);
                System.out.println(effect);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

