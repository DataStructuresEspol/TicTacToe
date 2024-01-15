package com.espol.tictactoe.logic;

import com.espol.tictactoe.model.Player;

public abstract class GameMode {
    public abstract String toString();

    public abstract Player playerOne();

    public abstract Player playerTwo();
}
