package com.nxg.controller;

import com.nxg.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nxg
 * date 2022/7/28
 * @apiNote
 */
@Controller
public class JsonController {

    @RequestMapping("getuser")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setUsername("张若昀");
        user.setAge(18);
        System.out.println("user请求");
        return user;
    }
    @RequestMapping("getusers")
    @ResponseBody
    public List<User> getUsers(){
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername("张若昀"+i);
            user.setAge(18+i);
            list.add(user);
        }
        System.out.println("所有用户请求");
        return list;
    }
}
