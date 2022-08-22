package com.java.dao;

import com.java.bean.User;

import java.util.List;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public interface UserDao {

    //新增用户
    public int insertUser(User user);
    //通过id查询用户
    public User findById(int id);
    //查询所有信息
    public List<User> findAll();
}
