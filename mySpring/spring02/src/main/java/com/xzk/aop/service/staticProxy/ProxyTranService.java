package com.xzk.aop.service.staticProxy;

import com.xzk.aop.service.IService;

/**
 * 代理类和被代理类实现同一个接口
 */
public class ProxyTranService implements IService {

    private IService service;//被代理对象
    //构造方法
    public ProxyTranService(IService service) {
        this.service = service;
    }

    @Override
    public void add() {
        try {
            System.out.println("开始事务----");
            service.add();//核心业务就是由被代理对象完成的,其他服务性功能由代理类来完成.
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
        }
    }
}
