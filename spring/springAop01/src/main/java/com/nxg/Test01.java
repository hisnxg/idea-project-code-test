package com.nxg;

import com.nxg.dao.UserDao;
import com.nxg.dao.impl.UserDaoImpl;
import com.nxg.proxy.ProxyJdk;

import java.lang.reflect.Proxy;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 * 使用jdk动态动态代理实现
 * 方法前后添加日志
 */
public class Test01 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        //由代理类调用方法
        ProxyJdk p = new ProxyJdk(userDao);
        //生成代理对象
        UserDao o = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), p);
        //有代理类调用方法
        o.test1();
    }
}
