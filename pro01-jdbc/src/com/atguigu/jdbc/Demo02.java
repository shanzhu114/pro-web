package com.atguigu.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceshi?useSSL=false&useEncode=true&characterEncoding=UTF-8","root", "xjc@123");
        PreparedStatement ps = connection.prepareStatement("select * from a");
        ResultSet rs = ps.executeQuery();
        List<Fruit> list = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Fruit fruit = new Fruit(id, name);
            list.add(fruit);
        }

        rs.close();
        ps.close();

        list.forEach(System.out::println);
        System.out.println("GIT TEST");
    }
}
