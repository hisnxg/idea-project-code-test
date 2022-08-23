package com.xzk.aop.service;

public class UserService implements IService {

    @Override
    public void add() {
        System.out.println("UserService-----add---");
    }
}
