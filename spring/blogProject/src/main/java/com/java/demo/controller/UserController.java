package com.java.demo.controller;

import com.java.demo.domain.User;
import com.java.demo.service.UserService;
import com.java.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

   /* @CrossOrigin
    @GetMapping("/findUserName/{username}")
    @ResponseBody
    public Result findByUserName(@PathVariable("username") String username){
        Result result = new Result();
        User byUsername = userService.findByUsername(username);
        result.setMsg("查询成功！");
        result.setCode("200");
        result.setData(byUsername);
        return result;
    }*/

    @CrossOrigin
    @PutMapping("/updateUser")
    @ResponseBody
    public Result updateUser(User user){
        Result result = new Result();
        int a = userService.update(user);
        if(a==1){
            result.setMsg(200+"");
            result.setMsg("修改成功！");
        }else {
            result.setCode(400+"");
            result.setMsg("修改失败！");
        }
        return result;
    }

    @CrossOrigin
    @PostMapping("/addUser")
    @ResponseBody
    public Result addUser(User user){
        Result result = new Result();
        int a = userService.insert(user);
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
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") int id){
        Result result = new Result();
        int a = userService.delete(id);
        if(a==1){
            result.setMsg(200+"");
            result.setMsg("删除成功！");
        }else {
            result.setCode(400+"");
            result.setMsg("删除失败！");
        }
        return result;
    }


}
