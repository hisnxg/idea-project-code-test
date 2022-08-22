package com.nxg.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class CglibProxy implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("日志开始------------cglib");
        //目标方法（真实方法的调用） invokeSuper
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("日志结束-----------cglib");
        return o1;
    }
}
