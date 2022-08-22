package com.nxg.Service.impl;

import com.nxg.Service.UsersService;
import com.nxg.bean.Users;
import com.nxg.dao.UsersDao;
import com.nxg.dao.impl.UsersDaoImpl;

/**
 * @author nxg
 * date 2022/7/7
 * @apiNote
 */
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public void setUsersDao(UsersDao usersDao) {
        System.out.println("setUsersDao");
        this.usersDao = usersDao;
    }

    public void insert(Users users){
        System.out.println("UsersServiceImpl"+users);

    }
}
