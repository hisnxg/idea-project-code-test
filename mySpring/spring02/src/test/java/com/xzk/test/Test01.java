package com.xzk.test;

import com.xzk.aop.aop.AOP;
import com.xzk.aop.aop.LogAop;
import com.xzk.aop.aop.TranAop;
import com.xzk.aop.service.IService;
import com.xzk.aop.service.staticProxy.ProxyAOPService;
import com.xzk.aop.service.staticProxy.ProxyLogService;
import com.xzk.aop.service.staticProxy.ProxyTranService;
import com.xzk.aop.service.TeamService;
import com.xzk.aop.service.UserService;
import org.junit.Test;

public class Test01 {

    @Test
    public void test02(){
        IService teamService = new TeamService();//被代理对象---核心内容
        AOP logAop = new LogAop();//切面---服务内容
        AOP tranAop = new TranAop();
        IService service = new ProxyAOPService(teamService,logAop);// 代理对象--一级代理
        IService service2 = new ProxyAOPService(service,tranAop);//代理对象---二级代理
        service2.add();
    }


    public static void main(String[] args){
        TeamService teamService = new TeamService();//被代理对象
        UserService userService = new UserService();//被代理对象
        ProxyTranService tranService = new ProxyTranService(userService);//事务的代理对象--一级代理
        tranService.add();//代理对象干活

        ProxyLogService proxyLogService = new ProxyLogService(tranService);//日志的代理对象--二级代理
        proxyLogService.add();
    }
}
