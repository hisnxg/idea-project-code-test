package com.nxg;

import com.nxg.bean.User;
import com.nxg.proxy.CglibProxy;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author nxg
 * date 2022/7/16
 * @apiNote
 */
public class TestCglib {
    public static void main(String[] args) {
        //1. 创建真实对象
        User user = new User();
        //2.创建cglib代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(user.getClass());//超类
        enhancer.setCallback(new CglibProxy());
        //3.代理对象
        User o = (User) enhancer.create();
        o.test02();

    }
}
