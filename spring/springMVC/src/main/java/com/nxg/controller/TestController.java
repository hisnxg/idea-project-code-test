package com.nxg.controller;

import com.nxg.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author nxg
 * date 2022/7/19
 * @apiNote
 */
@Controller
@SessionAttributes("sessionAttribute")
public class TestController {

    /*@RequestMapping(method= RequestMethod.GET,value = "/test")
    public String test1(){
        System.out.println("请求成功-----被执行！");
        return "success";//返回结果页面，这里是返回结果页面的名称  =》 /success.jsp
    }*/
//获取参数的三种方式    HttpServletRequest   参数与方法传递的参数名保持一致
/*    @RequestMapping("/test")
    public String test1(HttpServletRequest request){
        System.out.println("请求成功-----被执行！");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        return "success";//返回结果页面，这里是返回结果页面的名称  =》 /success.jsp
    } */

/*    @RequestMapping("/test")  //@RequestParam 注解的使用，传递的参数名可以不相同，使用该注解设置名称即可
    public String test1(@RequestParam("username") String name,@RequestParam(name = "age",defaultValue = "18") int age){
        System.out.println("请求成功-----被执行！");
        System.out.println("username="+name+",age="+age);
        return "success";//返回结果页面，这里是返回结果页面的名称  =》 /success.jsp
    }*/

    /*@RequestMapping("/test")
    public String test1(User user){
        System.out.println("请求成功-----被执行！");
        System.out.println("username="+user.getUsername()+",age="+user.getAge());
        return "success";//返回结果页面，这里是返回结果页面的名称  =》 /success.jsp
    }*/
//接收日期转
    /*@RequestMapping("test3")
    public String test3(Date birthday){
        System.out.println(birthday);
        return "success";
    }*/

    /*@RequestMapping("test3")
    public String test3(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday, HttpServletRequest request, ModelMap modelMap, Model model){
        System.out.println(birthday);
        //request存值转发时显示，重定向时丢失
        request.setAttribute("birthday",birthday);
        modelMap.addAttribute("modelmapkey",birthday);
        model.addAttribute("modelKey",birthday);
        return "success";
    }*/
    /*@RequestMapping("test3")
    public ModelAndView test3(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("mvKey",birthday);
        return modelAndView;
    }*/
    /*@RequestMapping("test3")
    public String test1(@RequestParam("username") String name,@RequestParam(name = "age",defaultValue = "18") int age,@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday
                        ,HttpSession session){
        System.out.println("请求成功-----被执行！");
        System.out.println("username="+name+",age="+age);
        session.setAttribute("sessionName",name);
        return "success";//返回结果页面，这里是返回结果页面的名称  =》 /success.jsp
    }*/
    @RequestMapping("test3")
    public String test1(@RequestParam("username") String name, @RequestParam(name = "age",defaultValue = "18") int age, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday
            , ModelMap map){
        map.addAttribute("sessionAttribute",name);

        return "success";//返回结果页面，这里是返回结果页面的名称  =》 /success.jsp
    }

    @RequestMapping("/out") //基于HttpSession清除数据
    public String signOut(HttpSession session){
        session.invalidate();
        return "redirect:signout.jsp";//使用重定向时，视图解析器会失效，
    }
    /*@RequestMapping("/out3")
    public String signOut3(SessionStatus sessionStatus){
       sessionStatus.setComplete();
        return "signout";
    }*/
    @RequestMapping("/out3") //基于SessionAttribute注解数据
    public void signOut4(SessionStatus sessionStatus, HttpServletResponse response){
        sessionStatus.setComplete();
        response.setContentType("text/html;charset=utf-8");
        try{
            PrintWriter writer = response.getWriter();
            writer.append("<script>alert('退出成功！');location.href='signout.jsp'</script>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("test2")
    public ModelAndView test2(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,String uname){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("birthday",birthday);
        modelAndView.addObject("uname",uname);
       // System.out.println(3/0);
        return modelAndView;
    }

    //处理异常
    @ExceptionHandler(Exception.class)
    public String error(){
        System.out.println("error------------");
        return "error";
    }
}
