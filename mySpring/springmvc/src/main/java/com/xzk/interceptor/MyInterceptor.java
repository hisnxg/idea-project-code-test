package com.xzk.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
        //执行时间： 控制器方法执行之前，在ModelAndView返回之前
    //使用场景: 登录验证
    // 返回值 true : 继续执行控制器方法 表示放行 false: 不会继续执行控制器方法，表示拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle-------------------");
        return true;
    }
    //执行时间： 控制器方法执行之hou后，在ModelAndView返回之前，有机会修改返回值
//使用场景: 日记记录，记录登录的ip,时间
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle-------------------");
    }
    //执行时间： 控制器方法执行之后，在ModelAndView返回之后，没有机会修改返回值
//使用场景: 全局资源的一些操作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion-------------------");
    }
}
