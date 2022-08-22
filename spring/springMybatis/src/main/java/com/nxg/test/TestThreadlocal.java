package com.nxg.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nxg
 * date 2022/8/4 08 50
 * @apiNote
 */
public class TestThreadlocal {
    private ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    private List<String> list = new ArrayList<String>();
    class A extends Thread {

        @Override
        public void run() {
            //存值
            System.out.println("A线程开始存数据----");
            threadLocal.set("A存的内容");
            list.add("list内容");
            System.out.println("A------------threadLocal="+threadLocal.get());
            System.out.println("A-----------list="+list.get(0));
        }
    }
    class B extends Thread{
        @Override
        public void run() {
            //取值
            System.out.println("B线程开始取数据--------");
            System.out.println("B------threadLocal="+threadLocal.get());
            System.out.println("B------list="+list.get(0));
        }
    }

    public static void main(String[] args) {
        TestThreadlocal testThreadlocal = new TestThreadlocal();
        TestThreadlocal.A a = testThreadlocal.new A();
        TestThreadlocal.B b = testThreadlocal.new B();
        a.start();
        b.start();
    }
}
