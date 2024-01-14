package com.espol.tictactoe.logic;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.model.Bot;
import com.espol.tictactoe.model.GameData;
import com.espol.tictactoe.model.Player;

public class PcvsPc extends GameMode {

    @Override
    public String toString() {
        return "Computadora vs Computadora";
    }

    @Override
    public Player playerOne() {
        return new Bot();
    }

    @Override
    public Player playerTwo() {
        return new Bot();
    }

    @Override
    public void play(GameData gameData, GamePlay gamePlay) {

    }
}
