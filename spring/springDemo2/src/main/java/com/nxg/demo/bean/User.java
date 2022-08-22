package com.nxg.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 * 默认是单例
 *  * 多例
 * @Scope(scopeName = "prototype")
 * prototype
 */
@Component("u1")
@Scope(scopeName = "prototype")
public class User {

    @Value("郭德纲")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @PostConstruct
    public void init(){
        System.out.println("通过注解实现-----初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("通过注解实现-----销毁的方法");
    }
}
