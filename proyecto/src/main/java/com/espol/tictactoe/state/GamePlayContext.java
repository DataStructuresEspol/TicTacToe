package com.espol.tictactoe.state;

import com.espol.tictactoe.model.GameData;

public class GamePlayContext {
    private final static GamePlayContext instance = new GamePlayContext();

    public static GamePlayContext getInstance() {
        return instance;
    }

    private final GameData gameData = new GameData();

    public GameData getGameData() {
        return gameData;
    }
}
