package com.java.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class MyAop {

    //前置增强 ---目标方法之前执行
    public void before(JoinPoint joinPoint){
        System.out.println("前置增强-----日志开始");
        System.out.println(new Date()+",获得切点对象="+joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("切点方法"+joinPoint.getSignature().getName());
        System.out.println("切点参数："+joinPoint.getArgs());
    }
    //后置增强 --- 目标方法之后执行
    public void after(){
        System.out.println("后置增强-----------日志结束");
    }

    public void myAround(ProceedingJoinPoint joinPoint){
        System.out.println("环绕增强-----------日志开始 ");
        try {
            joinPoint.proceed();//调取目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕增强--------日志结束");
    }
    public void myFinally(){
        System.out.println("最终增强----------- ");
    }
    public void myException(){
        System.out.println("异常增强----------");
    }
}
