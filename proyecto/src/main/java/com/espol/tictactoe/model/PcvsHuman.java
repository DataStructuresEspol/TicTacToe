package com.espol.tictactoe.model;

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
