package com.java.dao.impl;

import com.java.bean.User;
import com.java.dao.UserDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
@Service("uservice")
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Transactional
    public int insertUser(User user) {
        //添加用户信息
        String sql = "insert into user(username,password,age) values(?,?,?)";
        int update = getJdbcTemplate().update(sql, user.getUsername(), user.getPassword(), user.getAge());
//        System.out.println(5/0);
        return update;
    }

    public User findById(int id) {
        String sql = "select * from user where userId=?";
        User us = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                //和之前jdbc获取结果集之后的操作一样
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                return user;
            }
        });
        return us;
    }

    public List<User> findAll() {
        String sql = "select * from user";
        List<User> uList = getJdbcTemplate().query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                return user;
            }
        });
        return uList;
    }
}
