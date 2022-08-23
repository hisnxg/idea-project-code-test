package com.nxg.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nxg.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nxg
 * date 2022/2/28
 * @apiNote
 */
@RestController
@RequestMapping("/demo")
public class HelloController {

    /**
     * loadbalance 负载均衡 以random随机的方式
     */
    @Reference(loadbalance = "random") //import com.alibaba.dubbo.config.annotation.Reference;
    private HelloService helloService;

    @RequestMapping("/hello")
    public String sayHello(String name){
        //远程调用
        String result = helloService.sayHello(name);
        System.out.println(result);
        return result;
    }
}
