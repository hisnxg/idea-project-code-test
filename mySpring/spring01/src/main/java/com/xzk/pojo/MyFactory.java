package com.xzk.pojo;

public class MyFactory {
    /**
     * 实例方法
     */
    public Team instanceFun(){
        System.out.println("MyFactory----instanceFun");
        return new Team(1003,"湖人","洛杉矶");
    }
    /**
     * 静态方法
     */
    public static Team staticFun(){
        System.out.println("MyFactory----staticFun");
        return new Team(1004,"小牛","达拉斯");
    }

    public static void main(String[] args) {
        //1.通过静态方法创建
        Team team1 = MyFactory.staticFun();
        //2.通过实例方法创建
        MyFactory myFactory = new MyFactory();
        Team team = myFactory.instanceFun();
        //System.out.println(team);
    }
}
