package com.xzk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Component //切面对象的创建权限依然交给spring 容器
//@Aspect //aspectj 框架的注解    标识当前类是一个切面类
public class MyAspect {

    /**
     *     @Pointcut 注解表示切入点表达式,方法一般声明为私有
     *     其他的通知可以直接在value属性值 直接使用方法名称
     */
    @Pointcut("execution(* com.xzk.service..*.*(..))")
    private void pointCut(JoinPoint jp){ //jp 指定要处理的目标对象的方法


    }
    @Pointcut("execution(* com.xzk.service..*.update*(..))")
    private void pointCut2(){

    }
    /**
     * 声明前置通知
     * @param jp
     */
    @Before("pointCut()")
    public void before(JoinPoint jp){//连接点
        System.out.println("前置通知:在目标方法执行之前被调用的通知");
        String name = jp.getSignature().getName();
        System.out.println("拦截的方法名称:"+name);
        Object[] args = jp.getArgs();
        System.out.println("方法的参数格式:"+args.length);
        System.out.println("方法的参数列表:");
        for (Object arg : args) {
            System.out.println("\t"+arg);
        }
        System.out.println("前置通知：在目标对象方法执行之前执行");
        System.out.println("拦截要处理的方法名称：");
        String name2 = jp.getSignature().getName();//要处理方法的名字
        System.out.println("方法名："+name2);
        System.out.println("拦截要处理的方法的参数：");
        Object[] args2 = jp.getArgs();
        for (Object arg : args2){
            System.out.println("参数："+arg);
        }
    }

    /**
     * AfterReturning 注解声明后置通知
     * value:  表示切入点表达式
     * returning 属性表示 返回的结果,如果需要的话可以在后置通知的方法中修改结果
     * 拦截的是一组,不是一个
     */
    @AfterReturning(value="pointCut2()",returning = "result")
    public Object afterReturn(Object result){
        if (result!=null){
            boolean res = (boolean)result;
            if (res){
                result = false;
            }
        }
        System.out.println("后置通知:在目标方法执行之后被调用的通知,result+"+result);
        return result;
    }

    /**
     * Around 注解声明环绕通知
     * ProceedingJoinPoint  中的proceed方法表示目标方法被执行
     * @param pgj
     * @return
     */
    @Around(value="pointCut()")
    public Object around(ProceedingJoinPoint pgj){
        System.out.println("环绕通知:在目标方法执行之前被调用的通知");
        Object proceed =null;
        try {
             proceed = pgj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕方法---目标方法执行之后");
        return proceed;
    }

    /**
     * AfterReturning 注解声明异常通知
     * value:  表示切入点表达式
     * returning 属性表示 返回的结果,如果需要的话可以在异常通知的方法中修改结果
     * 拦截的是一组,不是一个
     */
    @AfterThrowing(value="pointCut2()",throwing = "tw")
    public void exception(JoinPoint jp,Throwable tw){
        System.out.println("异常通知:在目标方法执行出现异常的时候才会调用的通知,否者不执行");
        System.out.println(jp.getSignature()+"方法出现异常,异常信息是:"+tw.getMessage());
    }

    /**
     * After 注解声明最终通知
     */
    @After(value="pointCut()")
    public void myFinally(){
        System.out.println("最后通知:无论是否出现异常都会被调用的通知");
    }
}
