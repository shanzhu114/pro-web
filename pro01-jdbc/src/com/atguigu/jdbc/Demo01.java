package com.atguigu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.根据驱动管理器获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceshi?useSSL=false&useEncode=true&characterEncoding=utf-8", "root", "xjc@123");
        //3.编写sql语句
        String sql = "insert into a value(0,?)";
        Fruit fruit = new Fruit(4, "peach");

        //4.通过预处理
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1,fruit.getA_name());
        int count = psmt.executeUpdate();
        System.out.println(count>0?"添加成功！":"添加失败！");

        System.out.println("conn=" + conn);

        psmt.close();
        conn.close();


    }
}
