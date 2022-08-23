package com.xzk.aop.service;

public class TeamService implements IService {

    @Override //加注解检查代码
    public void add(){
        System.out.println("TeamService---add---");//核心业务
    }

}
