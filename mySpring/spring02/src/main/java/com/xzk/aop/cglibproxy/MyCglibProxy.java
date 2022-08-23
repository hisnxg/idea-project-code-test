package com.xzk.aop.cglibproxy;

import com.xzk.aop.aop.AOP;
import com.xzk.aop.aop.TranAop;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy {
    public static void main(String[] args) {
        //目标对象
        NBAService nbaService = new NBAService();//没有实现接口
        //创建切面
        AOP tranAop = new TranAop();
        //创建代理对象,选择cglib动态代理
        NBAService proxyInstance = (NBAService) new CglibProxyFactory().getProxyInstance(nbaService, tranAop);
        int res = proxyInstance.add("huren",1010);
        System.out.println(res);
    }
    public static void main1(String[] args) {
        //目标对象:没有接口
        NBAService nbaService = new NBAService();
        //创建代理对象,选择cglib动态代理
        NBAService proxyService =(NBAService) Enhancer.create(nbaService.getClass(),
                new MethodInterceptor() {//回调函数 负责编写代理规则
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        Object invoke = null;//核心
                        try {
                            System.out.println("开始事务");
                            invoke = methodProxy.invokeSuper(o, objects);//核心
                            System.out.println("提交事务");
                        } catch (Throwable throwable) {
                            System.out.println("事务回滚");
                            throwable.printStackTrace();
                        } finally {
                            System.out.println("finally--------------");
                        }
                        return invoke;
                    }
                });
        //代理对象干活
        int res = proxyService.add("huren",1001);
        System.out.println(res);
    }
}
