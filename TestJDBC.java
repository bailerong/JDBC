package com.lele.jdbc;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;

public class TestJDBC {
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
        try {
            Connection connection=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/memo?user=root&password=369888abc&useSSL=false");

            //创建命令
           Statement statement=connection.createStatement();
           ResultSet resultSet=statement.executeQuery
                   ("select id,name,created_time,modify_time from memo_group ");
           //返回结果集，处理结果
            while(resultSet.next()){
                //如果返回true表示有下一行记录，否则无计记录
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
               LocalDateTime createdTime=
                       resultSet.getTimestamp("created_time").toLocalDateTime();
               LocalDateTime modifyTime=
                       resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(
                        String.format(
                                "编号:%d,名称:%s,创建时间:%s,修改时间:%s",
                                id,name,
                                createdTime.toString(),
                                modifyTime.toString()
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
