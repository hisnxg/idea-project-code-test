package com.xzk.pojo;

import java.util.Date;
import java.util.List;

public class Team1 {
    private Integer teamId;
    private String teamName;
    private String location;
    private Date createTime;
    //一对多的体现：一方持有多方的对象
    private List<Player> playerList1;//关联对象--一个球队可以拥有多个球员
    private List<Player> playerList2;//关联对象--一个球队可以拥有多个球员
    public Team1() {
    }

    public Team1(Integer teamId, String teamName, String location, Date createTime) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.location = location;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Team1{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", location='" + location + '\'' +
                ", createTime=" + createTime +
                ", playerList1=" + playerList1 +
                ", playerList2=" + playerList2 +
                '}';
    }

    public List<Player> getPlayerList1() {
        return playerList1;
    }

    public void setPlayerList1(List<Player> playerList1) {
        this.playerList1 = playerList1;
    }

    public List<Player> getPlayerList2() {
        return playerList2;
    }

    public void setPlayerList2(List<Player> playerList2) {
        this.playerList2 = playerList2;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
