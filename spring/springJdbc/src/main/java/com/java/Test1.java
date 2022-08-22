package com.java;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        //1.    创建数据库连接池， c3p0
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sys1?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        //2.    创建工具类
        JdbcTemplate template = new JdbcTemplate(dataSource);
        //3.    调取方法 增删改使用update  查询使用query
        int update = template.update("insert into user(username,password,age) values('郭德纲','guo123',18)");
        System.out.println("status="+update);
    }
}
