package com.xzk.pojo;

public class Player {
    private Integer playerId;
    private String playerName;
    private Integer playerNum;
    private Integer teamId;
    //多对一的体现：多方持有一方的对象 要有get方法
    private Team1 team1;//关联对象--多个球员可以属于同一个球队；
    private Team1 team2;//关联对象--多个球员可以属于同一个球队；
    private Team1 team3;//关联对象--多个球员可以属于同一个球队；

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", playerNum=" + playerNum +
                ", teamId=" + teamId +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", team3=" + team3 +
                '}';
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(Integer playerNum) {
        this.playerNum = playerNum;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Team1 getTeam1() {
        return team1;
    }

    public void setTeam1(Team1 team1) {
        this.team1 = team1;
    }

    public Team1 getTeam2() {
        return team2;
    }

    public void setTeam2(Team1 team2) {
        this.team2 = team2;
    }

    public Team1 getTeam3() {
        return team3;
    }

    public void setTeam3(Team1 team3) {
        this.team3 = team3;
    }
}
