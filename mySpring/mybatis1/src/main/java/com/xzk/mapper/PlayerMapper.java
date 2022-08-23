package com.xzk.mapper;

import com.xzk.pojo.Player;

import java.util.List;

public interface PlayerMapper {
    Player queryById(int playerId);
    Player queryById1(int playerId);
    Player queryById2(int playerId);
    Player queryById3(int playerId);

    List<Player> queryByTeamId(int teamId);
}
