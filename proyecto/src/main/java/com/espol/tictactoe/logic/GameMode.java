package com.espol.tictactoe.logic;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.model.GameData;
import com.espol.tictactoe.model.Player;

public abstract class GameMode {
    public abstract String toString();

    public abstract Player playerOne();

    public abstract Player playerTwo();

    public abstract void play(GameData gameData, GamePlay gamePlay);


}
