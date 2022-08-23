package com.xzk.aop.cglibproxy;

import com.xzk.aop.aop.AOP;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory {
    //目标对象
    private NBAService nbaService;//没有实现接口
    //切面
    private AOP aop;

    /**
     * 创建动态代理对象
     * 创建动态cglib代理对象
     * @param nbaService
     * @param aop
     * @return
     */
    public Object getProxyInstance(NBAService nbaService,AOP aop){
       return Enhancer.create(nbaService.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        Object o1 = null;//核心
                        try {
                            aop.before();
                            o1 = methodProxy.invokeSuper(o, objects);//核心
                            aop.after();
                        } catch (Exception e) {
                            aop.exception();
                            throw e;//抛出异常
                        } finally {
                            System.out.println("finally---------------");
                        }
                        return o1;
                    }
                });

    }
}
