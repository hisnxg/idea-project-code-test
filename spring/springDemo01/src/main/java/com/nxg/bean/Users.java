package com.nxg.bean;

/**
 * @author nxg
 * date 2022/7/7
 * @apiNote
 */
public class Users {

    public Users() {

    }

    public void initTest(){
        System.out.println("---init -----初始化方法");
    }
    public void destroyMethod(){
        System.out.println("销毁的方法--------");
    }
    public static   Users  getUsers(){
        System.out.println("static -----users1-----getusers");
        return  new Users();
    }
    public   Users  getUsers2(){
        System.out.println("非静态的-------users2-----getusers2");
        return  new Users();
    }

    private String username;
    private int age;

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, int age) {
        System.out.println("t通过构造方法----username="+username+",age="+age);
        this.username = username;
        this.age = age;
    }

    public Users(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
