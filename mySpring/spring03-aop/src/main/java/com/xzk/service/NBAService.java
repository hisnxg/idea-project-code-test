package com.xzk.service;

import org.springframework.stereotype.Service;

/**
 * 核心业务类
 */
@Service("nbaService")
public class NBAService implements IService {

    @Override
    public void add(int id,String name) {
        //int num = 10/0;//出现异常
        System.out.println("NBAService---add");//核心业务
    }

    @Override
    public boolean update(int num) {
        if (num > 666){
            return true;
        }
        return false;
    }
}
