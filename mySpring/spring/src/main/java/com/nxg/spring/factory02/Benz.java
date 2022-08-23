package com.nxg.spring.factory02;

/**
 * @author nxg
 * date 2022/1/20
 * @apiNote
 */
public class Benz implements Car{
    @Override
    public void start() {
        System.out.println("奔驰启动了");
    }

    @Override
    public void run() {
        System.out.println("奔驰跑起来了");
    }

    @Override
    public void stop() {
        System.out.println("奔驰停止了");
    }
}
