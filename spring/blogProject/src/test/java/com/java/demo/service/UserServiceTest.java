package com.java.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.demo.domain.User;
import com.java.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
//@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void findByUsername() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","user01");
        User user = (User)userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("qwer");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    void delete() {

    }
}