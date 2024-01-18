package com.espol.tictactoe.state;

import com.espol.tictactoe.model.Game;

public class GamePlayContext {
    private final static GamePlayContext instance = new GamePlayContext();

    public static GamePlayContext getInstance() {
        return instance;
    }

    private final Game game = new Game();

    public Game getGameData() {
        return game;
    }
}
