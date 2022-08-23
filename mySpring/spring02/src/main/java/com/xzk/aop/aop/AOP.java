package com.xzk.aop.aop;

/**
 * 面向切面编程
 */
public interface AOP {
    void before();//核心业务之前插入
    void after();//核心业务之后插入
    void exception();//异常
    void myFinally();//最后
}
