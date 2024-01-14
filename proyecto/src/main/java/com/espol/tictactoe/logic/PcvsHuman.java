package com.espol.tictactoe.logic;

import com.espol.tictactoe.model.Bot;
import com.espol.tictactoe.model.Human;
import com.espol.tictactoe.model.Player;

public class PcvsHuman extends GameMode {

    @Override
    public String toString() {
        return "Computadora vs Humano";
    }

    @Override
    public Player playerOne() {
        return new Bot();
    }

    @Override
    public Player playerTwo() {
        return new Human();
    }
}
