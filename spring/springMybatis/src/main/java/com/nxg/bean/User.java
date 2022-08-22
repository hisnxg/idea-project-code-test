package com.nxg.bean;

/**
 * @author nxg
 * date 2022/7/31
 * @apiNote 多方
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private Integer age;
    //private char gender;
    private char sex;

    //多对一时， 多方中有一方的信息
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public User() {
    }

    public User(int userId, String username, String password, Integer age) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public User(int userId, String username, String password, Integer age, char sex) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDao2{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +'\'' +
                ", gender=" + sex +
                '}';
    }
}
