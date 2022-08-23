package com.xzk.aop.dynamicProxy;

import com.xzk.aop.aop.AOP;
import com.xzk.aop.service.IService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxayFactory {
    private IService service;//目标对象
    private AOP aop;//切面

    public ProxayFactory(IService service, AOP aop) {
        this.service = service;
        this.aop = aop;
    }

    /**
     * 获取代理的实例
     * @return
     */
    public Object getProxyInstance(){
        //返回代理对象 基于JDK的动态代理
        return Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new InvocationHandler() {//回调函数  编写代理规则
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
        );
    }
}
