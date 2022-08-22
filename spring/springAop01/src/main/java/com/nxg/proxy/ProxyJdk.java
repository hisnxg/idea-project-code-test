package com.nxg.proxy;

import com.nxg.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote jdk动态代理
 * 主要针对接口创建代理实例
 */
public class ProxyJdk implements InvocationHandler {

    private UserDao userDao;

    public ProxyJdk(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 定义代理类需要做的事
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前开始添加日志");
        //调用真实方法
        Object invoke = method.invoke(userDao, args);
        //
        System.out.println("方法之后添加日志");
        return invoke;
    }
}
