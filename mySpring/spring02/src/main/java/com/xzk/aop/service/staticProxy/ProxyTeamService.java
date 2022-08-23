package com.xzk.aop.service.staticProxy;

import com.xzk.aop.service.TeamService;

/**
 * 基于类的静态代理:
 *  要求继承被代理的类
 *  弊端:每次只能代理一个类
 */
public class ProxyTeamService extends TeamService {

    public void add(){
        try {
            System.out.println("开始事务----");
            super.add();//核心业务就是由被代理对象完成的,其他服务性功能由代理类来完成.
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
        }
    }

}
