package com.xzk.pojo;

import org.springframework.stereotype.Component;

/**
 * 球队的实体类
 */
@Component
public class Team {

    private Integer id;

    private String  name;

    private String location;

    public Team() {
    }

    public Team(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Team(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
