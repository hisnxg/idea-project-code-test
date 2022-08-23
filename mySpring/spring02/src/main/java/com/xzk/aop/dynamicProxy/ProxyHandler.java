package com.xzk.aop.dynamicProxy;

import com.xzk.aop.aop.AOP;
import com.xzk.aop.service.IService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler{
    private IService service;//目标对象
    private AOP aop;//切面

    public ProxyHandler(IService service, AOP aop) {
        this.service = service;
        this.aop = aop;
    }

    @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    aop.before();
                    Object invoke = method.invoke(service, args);//核心业务
                    aop.after();
                    return invoke;
                } catch (Exception e) {
                    aop.exception();
                    e.printStackTrace();
                    throw e;
                } finally {
                    aop.myFinally();
                }
            }
}
