package com.java.util;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class BeforeAop implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("特殊的前置增强");
        System.out.println("目标方法信息："+o.getClass().getSimpleName());
        System.out.println("对象信息："+o);
    }
}
