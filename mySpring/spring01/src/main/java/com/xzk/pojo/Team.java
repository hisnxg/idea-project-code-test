package com.xzk.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 球队的实体类
 */
@Component
public class Team {
    @Value("1001")
    private Integer id;
    @Value("湖人")
    private String  name;
    @Value("洛杉矶")
    private String location;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Team(){
        System.out.println("Team - 默认的构造方法 id="+id+",name="+name+",location="+location);
    }

    //带参数的构造方法
    public Team(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        System.out.println("Team - 带参数的构造方法 id="+id+",name="+name+",location="+location);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void init(){
        System.out.println("Team --- init()-----");
    }
    public void destroy(){
        System.out.println("Team --- destroy()-----");
    }
}
