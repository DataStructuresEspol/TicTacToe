package com.espol.tictactoe.model;

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
