package com.xzk.controller;

import com.xzk.pojo.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("result")
public class ResultController {


    //3、返回对象类型：Integer Double String 自定义类型 List Map
    // 返回的不是逻辑视图的名称，而直接就是数据返回 ，一般是ajax请求搭配使用 ，将json格式的数据直接返回给响应体
  // 一定要与@ResponseBody
    @ResponseBody
    @RequestMapping("test03-1")
    public Integer test031(){
        return 666;
    }
    @ResponseBody
    @RequestMapping("test03-2")
    public String test032(){
        return "test";
    }
    @ResponseBody
    @RequestMapping("test03-3")
    public Team test033(){
        Team team=new Team();
        team.setLocation("迈阿密");
        team.setTeamId(1002);
        team.setTeamName("热火");
        return team;
    }
    @ResponseBody
    @RequestMapping("test03-4")
    public List<Team> test034(){
        List<Team> list=new ArrayList<>(5);
        for(int i=1;i<=5;i++) {
            Team team = new Team();
            team.setLocation("迈阿密"+i);
            team.setTeamId(1002+i);
            team.setTeamName("热火"+i);
            list.add(team);
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("test03-5")
    public Map<String,Team> test035(){
        Map<String,Team> map=new HashMap();
        for(int i=1;i<=5;i++) {
            Team team = new Team();
            team.setLocation("金州"+i);
            team.setTeamId(1000+i);
            team.setTeamName("勇士"+i);
//日期类型，在返回的时候是个数字，如果想要按日期格式展示需要在实体类对应属性添加注解@JsonFormat(pattern = "yyyy-MM-dd")
            team.setCreateTime(new Date());
            map.put(team.getTeamId()+"",team);
        }
        return map;
    }
    //通过 HttpServletRequest 做服务端跳转
    @RequestMapping("test04-1")
    public void test041(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        System.out.println("直接使用HttpServletRequest进行服务器端的转发");
        request.getRequestDispatcher("/jsp/ok.jsp").forward(request,response);
    }
    //通过 HttpServletResponse 做重定向
    @RequestMapping("test04-2")
    public void test042(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        System.out.println("直接使用HttpServletResponse重定向跳转");
        response.sendRedirect("/jsp/ok.jsp");
    }
    //通过 HttpServletResponse 给出响应
    @RequestMapping("test04-3")
    public void test043(HttpServletResponse response) throws ServletException,
            IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("返回void类型测试---直接返回字符串");
        writer.flush();
        writer.close();
    }
    //也可以自己手动指定响应头去实现重定向：
    @RequestMapping("test04-4")
    public void test044(HttpServletResponse response) throws ServletException,
            IOException {
        response.setStatus(302);//设置响应码，302表示重定向
        response.setHeader("Location","/jsp/ok.jsp");
    }

    //2、返回字符串
    @RequestMapping("test02")
    public String test02(HttpServletRequest request){
        Team team=new Team();
        team.setLocation("迈阿密");
        team.setTeamId(1002);
        team.setTeamName("热火");
        //携带数据
        request.setAttribute("team",team);
        request.getSession().setAttribute("team",team);
        //资源的跳转
        return "result";// 经过视图解析器InternalResourceViewResolver的处理，将逻辑视图名称加上前后缀变为物理资源路径 /jsp/result.jsp
    }


    //1、返回值是ModelAndView： 这种方式既有数据的携带还有资源的跳转，可以选择该种方式
    @RequestMapping("test01")
    public ModelAndView test01(){
        ModelAndView mv=new ModelAndView();//模型与视图
        //携带数据
        mv.addObject("teamName","湖人队");//相当于request.setAttribute("teamName","湖人队“);
        mv.setViewName("result");// 经过视图解析器InternalResourceViewResolver的处理，将逻辑视图名称加上前后缀变为物理资源路径 /jsp/result.jsp
        return mv;
    }


}
