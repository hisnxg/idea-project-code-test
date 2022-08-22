package com.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
@Component //1.创建增强类对象
@Aspect //2.标记是增强类对象
public class MyAop {

    //定义切点，由于注解修饰方法，所以这里需要定义一个空方法
    @Pointcut("execution(* com.service.*.*(..))")
    public void abc(){

    }
    //前置增强 ---目标方法之前执行
    @Before("abc()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置增强-----日志开始");
        /*System.out.println(new Date()+",获得切点对象="+joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("切点方法"+joinPoint.getSignature().getName());
        System.out.println("切点参数："+joinPoint.getArgs());*/
    }
    //后置增强 --- 目标方法之后执行
    @AfterReturning("abc()")
    public void after(){
        System.out.println("后置增强-----------日志结束");
    }

    @Around("abc()")
    public void myAround(ProceedingJoinPoint joinPoint){
        System.out.println("环绕增强-----------日志开始 ");
        try {
            joinPoint.proceed();//调取目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕增强--------日志结束");
    }
    @After("abc()")
    public void myFinally(){

        System.out.println("最终增强----------- ");
    }
    @AfterThrowing("abc()")
    public void myException(){
        System.out.println("异常增强----------");
    }
}
