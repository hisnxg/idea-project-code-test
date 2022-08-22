package com.nxg.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nxg
 * date 2022/7/28
 * @apiNote  两个拦截器
 * 执行顺序
 *
 */
public class MyInterceptor2 implements HandlerInterceptor {


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1结束-拦截后执行2");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("无论是否有异常都会执行！----2");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器1-拦截前执行----2");
        //return false表示不继续往后执行，true表示继续执行;
        //拦截器开始-->controller-->拦截器结束1
        return true;
    }
}
