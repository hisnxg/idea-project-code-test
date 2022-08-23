package com.nxg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nxg.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nxg
 * date 2022/2/25
 * @apiNote
 * @Service注解默认使用的协议是dubbo协议，
 */
@Transactional
@Service(protocol = "dubbo",interfaceClass = HelloService.class) //注意是import com.alibaba.dubbo.config.annotation.Service;
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "8084 ，dubbo :"+name;
    }
}
