package com.xzk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("navigation")
public class NavigationController {

    @RequestMapping("test")
    public String test(){
        System.out.println("test-----------------");
        return "index";
    }

    @RequestMapping("test03-1")
    public ModelAndView test031(HttpServletRequest request){
        System.out.println("test03-1---转发到控制器");
        ModelAndView mv=new ModelAndView();
        mv.addObject("teamName","达拉斯小牛");
        mv.setViewName("forward:/navigation/test01-1");
        return mv;
    }
    @RequestMapping("test03-2")
    public ModelAndView test032(HttpServletRequest request){
        System.out.println("test03-1---重定向到控制器");
        ModelAndView mv=new ModelAndView();
        mv.addObject("teamName","kaierteren");
        mv.addObject("teamId","1003");
        mv.setViewName("redirect:/navigation/test01-1");//参数值直接追加到URL后面
        return mv;
    }
    @RequestMapping("test02-2")
    public ModelAndView test022(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("teamName","huangfeng");
        //存储在request作用域中的值以参数的形式追加在URL后面
        http://localhost:8080/jsp/ok.jsp?teamName=huangfeng&teamId=1002
        mv.addObject("teamId","1002");
        mv.setViewName( "redirect:/jsp/ok.jsp");//当添加了redirect前缀之后，视图解析器中的前后缀就失效了，必须自己编写绝对路径
        return mv;
    }

    @RequestMapping("test02-1")
    public String test021(HttpServletRequest request){
        request.setAttribute("teamName","勇士");//页面上无法获取到存储在request作用域中的值，请求中断了
        return "redirect:/jsp/ok.jsp";//当添加了redirect前缀之后，视图解析器中的前后缀就失效了，必须自己编写绝对路径
    }
    //1.转发到一个jsp页面
    //使用字符串转发
    @RequestMapping("test01-1")
    public String test011(HttpServletRequest request){
        request.setAttribute("teamName","热火");
        //return "ok";//默认方式:由视图解析器处理之后将逻辑视图转化为物理资源路径
        return "forward:/jsp/ok.jsp";//当添加了forward前缀之后,视图解析器中2的前缀就失效了,必须注解编写绝对路径
    }
    //使用ModelAndView转发
    @RequestMapping("test01-2")
    public ModelAndView test012(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("teamName","湖人");
        //mv.setViewName("ok");//默认方式:由视图解析器处理之后将逻辑视图转化为物理资源路径
        mv.setViewName("forward:/jsp/ok.jsp");//当添加了forward前缀之后,视图解析器中2的前缀就失效了,必须注解编写绝对路径
        return mv;
    }
}
