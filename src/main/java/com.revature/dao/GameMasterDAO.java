package com.revature.dao;

import com.revature.models.GameMaster;

import java.util.List;

public interface GameMasterDAO {

    public List<GameMaster> getAllGameMasters();
    public List<GameMaster> getAllGameMastersNoSout();
    public boolean addGameMaster(GameMaster gameMaster);





}
