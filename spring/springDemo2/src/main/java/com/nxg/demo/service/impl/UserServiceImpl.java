package com.nxg.demo.service.impl;

import com.nxg.demo.bean.User;
import com.nxg.demo.dao.UserDao;
import com.nxg.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
@Service("uservice")
public class UserServiceImpl implements UserService {
    //DI依赖注入  @Resource 等价于  @Autowired +  @Qualifier("udao2")
    @Autowired //默认使用byType
    @Qualifier("udao2")
    //@Resource(name="udao")
    private UserDao userDao;

/*    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void insert(User user) {
        System.out.println("UserServiceImpl");
        userDao.insert(user);
    }
}
