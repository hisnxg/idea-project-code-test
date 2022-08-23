package com.xzk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Component //切面对象的创建权限依然交给spring 容器
@Aspect //aspectj 框架的注解    标识当前类是一个切面类
public class MyAOP {

    public void before(JoinPoint jp){//连接点
        System.out.println("AOP前置通知:在目标方法执行之前被调用的通知");

    }
    public void afterReturn(Object result){
        System.out.println("AOP后置通知:在目标方法执行之后被调用的通知,result+"+result);
    }


    public Object around(ProceedingJoinPoint pgj){
        System.out.println("AOP环绕通知:在目标方法执行之前被调用的通知");
        Object proceed =null;
        try {
            proceed = pgj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("AOP环绕方法---目标方法执行之后");
        return proceed;
    }

    public void exception(JoinPoint jp,Throwable tw){
        System.out.println("AOP异常通知:在目标方法执行出现异常的时候才会调用的通知,否者不执行");
        System.out.println(jp.getSignature()+"方法出现异常,异常信息是:"+tw.getMessage());
    }

    public void myFinally(){
        System.out.println("AOP最后通知:无论是否出现异常都会被调用的通知");
    }
}
