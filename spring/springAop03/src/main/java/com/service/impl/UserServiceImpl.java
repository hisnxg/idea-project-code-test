package com.service.impl;


import com.dao.UserDao;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
@Service("uservice")
public class UserServiceImpl implements UserService {

    @Resource(name = "udao")
    private UserDao userDao;

    public void test1() {
//        System.out.println(8/0);
        System.out.println("UserServiceImpl-----------");
        userDao.test1();
    }

    public void test2() {
        System.out.println("UserServiceImpl-----------test2");
        userDao.test2();
    }
}
