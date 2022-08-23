package com.xzk.controller;

import com.xzk.exceptions.TeamIdException;
import com.xzk.exceptions.TeamNameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试异常处理的控制器
 */
@Controller
@RequestMapping("ex")
public class ExController {
    @RequestMapping("test01/{id}/{name}")
    public ModelAndView test01(@PathVariable("id") Integer teamId,@PathVariable("name") String teamName) throws TeamIdException,
            TeamNameException{
        ModelAndView mv=new ModelAndView();
        if(teamId<=1000){
            throw new TeamIdException("teamId不合法！必须在1000之上！");
        }
        if("test".equals(teamName)){
            throw new TeamNameException("teamName不合法！不能使用test!");
        }
        System.out.println(10/0);
        mv.setViewName("ok");
        return mv;
    }
    @ExceptionHandler(value =
            {TeamIdException.class,TeamNameException.class,Exception.class})
    public ModelAndView exHandler(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        if(ex instanceof TeamIdException)
            mv.setViewName("idError");
        else if(ex instanceof TeamNameException)
            mv.setViewName("nameError");
        else
            mv.setViewName("error");
        return mv;
    }
}

