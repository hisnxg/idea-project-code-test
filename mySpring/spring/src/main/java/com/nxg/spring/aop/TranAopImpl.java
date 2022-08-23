package com.nxg.spring.aop;

/**
 * @author nxg
 * date 2022/1/29
 * @apiNote
 */
public class TranAopImpl implements TranAop {
    @Override
    public void before() {
        System.out.println("开启事务");
    }

    @Override
    public void after() {
        System.out.println("提交事务");
    }

    @Override
    public void exception() {
        System.out.println("回滚事务");
    }

    @Override
    public void myFinally() {
        System.out.println("最终需要处理的事");
    }
}
