package com.xzk.aop.service.staticProxy;

import com.xzk.aop.aop.AOP;
import com.xzk.aop.service.IService;

public class ProxyAOPService implements IService {
    private IService service;//被代理对象
    private AOP aop;//要加入的切面

    public ProxyAOPService(IService service, AOP aop) {
        this.service = service;
        this.aop = aop;
    }

    @Override
    public void add() {
        try {
            aop.before();
            service.add();//被代理对象干活
            aop.after();
        }catch(Exception e){
            aop.exception();
        }finally{
            aop.myFinally();
        }
    }
}
