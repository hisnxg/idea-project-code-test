package com.xzk.aop.service.staticProxy;

import com.xzk.aop.service.IService;

public class ProxyLogService implements IService {

    private IService service;//被代理对象

    public ProxyLogService(IService service) {
        this.service = service;
    }

    @Override
    public void add() {
        try {
            System.out.println("开始日志----");
            service.add();//核心业务就是由被代理对象完成的,其他服务性功能由代理类来完成.
            System.out.println("提交日志");
        } catch (Exception e) {
            System.out.println("异常日志");
        }
    }
}
