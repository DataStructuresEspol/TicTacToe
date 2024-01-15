package com.espol.tictactoe.logic;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.model.GameData;
import com.espol.tictactoe.model.Human;
import com.espol.tictactoe.model.Player;

public class HumanvsHuman extends GameMode {

    @Override
    public String toString() {
        return "Humano vs Humano";
    }

    @Override
    public Player playerOne() {
        return new Human();
    }

    @Override
    public Player playerTwo() {
        return new Human();
    }
}
