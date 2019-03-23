package com.lele.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

public class TestdeleteJDBC {
    public static void main(String[] args) {
        //为什么这里搜索不到mysql的驱动
        /*
         * 因为Mysql-connector-java不在classpath*/
        //加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、链接数据库
        //关于数据库链接的URL格式JDBC规范里面也有定义
        //jdbc:database://host:port/databaseName? p1=v1&p2=v2
        //jdbc:mysql://localhost:3306/memo?user=root&password=369888abc
        //jdbc:mysql://localhost:3306/test?useSSL=false
        try ( Connection connection= DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/memo?user=root&password=369888abc&useSSL=false");
              //创建命令
              Statement statement=connection.createStatement();){
           int effect = statement.executeUpdate
                    ("delete from memo_group where id=2 ");
            System.out.println(effect);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
