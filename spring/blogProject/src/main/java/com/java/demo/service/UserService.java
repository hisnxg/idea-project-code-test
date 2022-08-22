package com.java.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.demo.domain.User;
import com.java.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userName);
        User user = (User)userMapper.selectOne(queryWrapper);
        return user;
    }

    public int update(User user) {
        return userMapper.updateById(user);
    }

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int delete(int id) {
        return userMapper.deleteById(id);
    }
}
