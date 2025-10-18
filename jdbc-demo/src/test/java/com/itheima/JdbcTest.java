package com.itheima;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest {

    /**
     * JDBC的入门程序
     */
    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "112445";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();

        //4.执行SQL语句
        int i = statement.executeUpdate("update user set age = 25 where id = 1");//DML语句都可以调用这个方法
        //返回的int类型的值，表示受影响的记录数
        System.out.println("SQL语句执行完毕后受影响的记录数：" + i);

        //5.释放资源
        statement.close();
        connection.close();
    }
}
