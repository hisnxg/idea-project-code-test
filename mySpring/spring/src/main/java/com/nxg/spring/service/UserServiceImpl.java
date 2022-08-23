package com.nxg.spring.service;


import com.nxg.spring.dao.UserDao;

/**
 * @author nxg
 * date 2022/1/9
 * @apiNote
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao1) {
        this.userDao = userDao1;
    }

    @Override
    public void addUser() {

        System.out.println("---------调用UserDao,插入User对象--------------");
        userDao.addUser();
    }
}
