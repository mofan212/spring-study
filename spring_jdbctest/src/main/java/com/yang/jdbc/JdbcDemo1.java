package com.yang.jdbc;


import java.sql.*;

/**
 * @author 默烦 2020/10/15
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1. 注册驱动
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8", "root", "123456");
        // 3. 获取操作数据库的预处理对象‘
        PreparedStatement pstm = connection.prepareStatement("select * from account");
        // 4. 执行SQL，得到结果集
        ResultSet resultSet = pstm.executeQuery();
        // 5. 遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        // 6. 释放资源
        resultSet.close();
        pstm.close();
        connection.close();
    }
}
