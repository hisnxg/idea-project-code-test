package com.xzk.controller;

import com.xzk.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    public ModelAndView update(){
        System.out.println("TeamController-----------add");
        teamService.add();
        ModelAndView mv = new ModelAndView();

        mv.setViewName("team/update");

        return mv;
    }

    @RequestMapping("hello.do")
    public ModelAndView add(){
        System.out.println("TeamController-----------add");
        teamService.add();
        ModelAndView mv = new ModelAndView();
        mv.addObject("teamName","湖人");
        mv.setViewName("index");;//未来经过springmvc的视图解析器处理，转换成物理资源路径,
        //相当于request.getRequestDispatcher("index.jsp").forward();
        //经过InternalResourceViewResolver对象的处理之后加上前后缀就变为了/jsp/index.jsp

        return mv;
    }
}
