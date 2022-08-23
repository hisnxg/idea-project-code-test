package com.xzk.service;

import org.springframework.stereotype.Service;

/**
 * 核心业务类
 */
@Service
public class TeamService implements IService {

    @Override
    public void add(int id,String name) {
        System.out.println("TeamService---add");//核心业务
    }

    @Override
    public boolean update(int num) {
        if (num > 666){
            return true;
        }
        return false;
    }
}
