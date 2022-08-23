package com.xzk.aop.dynamicProxy;

import com.xzk.aop.aop.AOP;
import com.xzk.aop.aop.LogAop;
import com.xzk.aop.aop.TranAop;
import com.xzk.aop.service.IService;
import com.xzk.aop.service.TeamService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理 结构优化
 */
public class MyJDKProxy {

    public static void main(String[] args) {
        //目标对象--被代理对象
        TeamService teamService = new TeamService();
        //切面
        AOP tranAop = new TranAop();
        AOP logAop = new LogAop();
        //获取代理对象
        IService service = (IService) new ProxayFactory(teamService,tranAop).getProxyInstance();
        IService proxyInstance = (IService) new ProxayFactory(service, logAop).getProxyInstance();
        //代理对象干活
        service.add();//核心业务+服务代码混合在一起的完整的业务员方法
    }

    public static void main2(String[] args) {
        //目标对象--被代理对象
        TeamService teamService = new TeamService();
        //切面
        AOP tranAop = new TranAop();

        //返回代理对象 基于JDK的动态代理
        IService proxyService = (IService)Proxy.newProxyInstance(
                teamService.getClass().getClassLoader(),
                teamService.getClass().getInterfaces(),
                new ProxyHandler(teamService,tranAop)
        );
        //代理对象干活
        proxyService.add();

        System.out.println(teamService.getClass());
        System.out.println(proxyService.getClass()+"------");
    }

    public static void main1(String[] args) {
        //目标对象--被代理对象
        TeamService teamService = new TeamService();
        //返回代理对象 基于JDK的动态代理
        IService proxyService = (IService)Proxy.newProxyInstance(
                teamService.getClass().getClassLoader(),
                teamService.getClass().getInterfaces(),
                new InvocationHandler() {//回调函数  编写代理规则
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            System.out.println("开始事务");
                            Object invoke = method.invoke(teamService, args);//核心业务
                            System.out.println("提交事务");
                            return invoke;
                        } catch (Exception e) {
                            System.out.println("回滚事务");
                            e.printStackTrace();
                            throw e;
                        } finally {
                            System.out.println("finally------");
                        }
                    }
                }
        );
        //代理对象干活
        proxyService.add();

        System.out.println(teamService.getClass());
        System.out.println(proxyService.getClass()+"------");
    }
}
