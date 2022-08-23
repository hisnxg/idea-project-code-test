package com.xzk.aop.cglibproxy;

public class NBAService {
    public int add(String name, int id){
        System.out.println("NBAService----add---");//核心业务
        return id;
    }
}
