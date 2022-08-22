package com.java.demo.controller;

import com.java.demo.domain.User;
import com.java.demo.service.UserService;
import com.java.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmountController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/register")
    public Result register(String username,String password) {
        Result result = new Result();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        long a = userService.insert(user);
        if(a==1){
            result.setMsg(200+"");
            result.setMsg("添加成功！");
        }else {
            result.setCode(400+"");
            result.setMsg("添加失败！");
        }

        return result;
    }

    @CrossOrigin
    @PostMapping("/login")
    public Result login(String username,String password){
        Result result = new Result();
        User user = userService.findByUsername(username);
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            result.setMsg(200+"");
            result.setMsg("登录成功！");
        }else {
            result.setCode(400+"");
            result.setMsg("登录失败！");//或密码错误或用户不存在
        }
        return result;
    }
    @CrossOrigin
    @PostMapping("/logout")
    public Result logout(String username,String password){
        Result result = new Result();
        result.setMsg(200+"");
        result.setMsg("退出成功！");
        return result;
    }
}
