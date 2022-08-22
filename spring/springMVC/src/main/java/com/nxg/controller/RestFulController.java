package com.nxg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author nxg
 * date 2022/7/28
 * @apiNote
 */
@Controller
public class RestFulController {

    @RequestMapping(value = "testrest/{myname}/{uage}",method = RequestMethod.GET)
    public String get(@PathVariable(value = "myname") String name, @PathVariable(value = "uage") int age){
        System.out.println("get请求"+"myname="+name+",uage="+age);
        return "getrequest";
    }
    @RequestMapping(value = "testrest/{myname}/{uage}",method = RequestMethod.POST)
    public String post(@PathVariable(value = "myname") String name, @PathVariable(value = "uage") int age){
        System.out.println("post请求"+"myname="+name+",uage="+age);
        return "postrequest";
    }
    @RequestMapping(value = "testrest/{myname}/{uage}",method = RequestMethod.PUT)
    public String put(@PathVariable(value = "myname") String name, @PathVariable(value = "uage") int age){
        System.out.println("put请求"+"myname="+name+",uage="+age);
        return "putrequest";
    }
    @RequestMapping(value = "testrest/{myname}/{uage}",method = RequestMethod.DELETE)
    public String del(@PathVariable(value = "myname") String name, @PathVariable(value = "uage") int age){
        System.out.println("delete请求"+"myname="+name+",uage="+age);
        return "deleterequest";
    }
}
