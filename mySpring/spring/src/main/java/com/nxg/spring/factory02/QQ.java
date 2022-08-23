package com.nxg.spring.factory02;

/**
 * @author nxg
 * date 2022/1/20
 * @apiNote
 */
public class QQ implements Car {
    @Override
    public void start() {
        System.out.println("QQ启动了");
    }

    @Override
    public void run() {
        System.out.println("QQ运行了");
    }

    @Override
    public void stop() {
        System.out.println("QQ停止了");
    }
}
