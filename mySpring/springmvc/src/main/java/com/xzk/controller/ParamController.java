package com.xzk.controller;

import com.xzk.pojo.Team;
import com.xzk.vo.QueryVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {

    //8、获取集合类型的参数: 简单类型的可以通过@RequestParam注解实现；对象集合不支持直接获
    //取，必须封装在类中，作为一个属性操作
    @RequestMapping("test08")
    public ModelAndView test08(@RequestParam("teamName") List<String> nameList){
        System.out.println("test08-----------------");
        for (String s : nameList) {
            System.out.println(s);
        }
        return new ModelAndView("ok");
    }
    @RequestMapping("test09")
    public ModelAndView test09(QueryVO vo){
        System.out.println("test09-----------------");
        for (Team team : vo.getTeamList()) {
            System.out.println(team);
        }
        return new ModelAndView("ok");
    }
    //7、获取数组类型的参数
    @RequestMapping("test07")
    public ModelAndView test07(String[] teamName,HttpServletRequest request){
        System.out.println("test07-----------------");
//方式1：
        for (String s : teamName) {
            System.out.println(s);
        }
        System.out.println("---------------");
//方式2：
        String[] teamNames = request.getParameterValues("teamName");
        for (String name : teamNames) {
            System.out.println(name);
        }
        return new ModelAndView("ok");
    }
    //6、获取日期类型的参数
    @RequestMapping("test06")
    public ModelAndView test06(Team team){
        System.out.println("test06-----------------");
        System.out.println(team);
        return new ModelAndView("ok");
    }
    //5、直接使用URL地址传参: 借助@PathVariable 注解
// 例如http://localhost:8080/param/test05/1001/lacker/las
    @RequestMapping("test05/{id}/{name}/{loc}")
    public ModelAndView test05(@PathVariable("id") Integer teamId,
                               @PathVariable("name") String teamName,
                               @PathVariable("loc") String teamLocation){
        System.out.println("test05-----------------");
        System.out.println(teamId);
        System.out.println(teamName);
        System.out.println(teamLocation);
        return new ModelAndView("ok");
    }
    //4、使用HttpServletRequest 对象获取参数：跟原来的javaWeb项目中使用的方式是一样的
    @RequestMapping("test04")
    public ModelAndView test04(HttpServletRequest request){
        System.out.println("test04-----------------");
        String teamId = request.getParameter("teamId");
        String teamName = request.getParameter("teamName");
        String location = request.getParameter("location");
        if(teamId!=null)
            System.out.println(Integer.valueOf(teamId));
        System.out.println(teamName);
        System.out.println(location);
        return new ModelAndView("ok");
    }
//3、请求参数和方法名称的参数不一致:使用@RequestParam进行矫正，
// value属性表示请求中的参数名称
// required属性表示参数是否是必须的：true:必须赋值，否则报出400错；false：可以不赋值，
    //结果就是null
    @RequestMapping("test03")
    public ModelAndView test03(@RequestParam(value = "teamId",required = false)
                                       Integer id,
                               @RequestParam(value = "teamName",required = true)
                                       String name,
                               @RequestParam("location") String loc){
        System.out.println("test03-----------------");
        System.out.println(id);
        System.out.println(name);
        System.out.println(loc);
        return new ModelAndView("ok");
    }
//2、使用对象接收多个参数：要求用户请求中携带的参数名称必须是实体类中的属性保持一致，否则就
    //获取不到
    @RequestMapping("test02")
    public ModelAndView test02(Team team){
        System.out.println("test02-----------------");
        System.out.println(team);
        return new ModelAndView("ok");
    }
    /**
     * 1、直接使用方法的参数逐个接收:方法的参数名称必须与用户请求中携带的参数名称保持一致，否则
     就获取不到
     * 好处：不需要类型转换
     */
    @RequestMapping("test01")
    public ModelAndView test01(Integer teamId,String teamName,String
            teamLocation){
        System.out.println("test01-----------------");
        System.out.println(teamId);
        System.out.println(teamName);
        System.out.println(teamLocation);
        return new ModelAndView("ok");
    }
    @RequestMapping("hello")
    public ModelAndView hello(){
        return new ModelAndView("hello");
    }

}
