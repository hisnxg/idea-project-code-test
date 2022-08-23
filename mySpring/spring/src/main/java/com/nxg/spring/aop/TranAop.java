package com.nxg.spring.aop;

/**
 * @author nxg
 * date 2022/1/29
 * @apiNote
 */
public interface TranAop {

    void before();
    void after();
    void exception();
    void myFinally();
}
