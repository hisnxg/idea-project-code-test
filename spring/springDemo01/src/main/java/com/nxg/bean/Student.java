package com.nxg.bean;

/**
 * @author nxg
 * date 2022/7/15
 * @apiNote
 */
public class Student {
    private String stuname;
    private int stuAge;
    private String sex;

    public Student() {
    }

    public Student(String stuname, int stuAge, String sex) {
        this.stuname = stuname;
        this.stuAge = stuAge;
        this.sex = sex;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuname='" + stuname + '\'' +
                ", stuAge=" + stuAge +
                ", sex='" + sex + '\'' +
                '}';
    }
}
