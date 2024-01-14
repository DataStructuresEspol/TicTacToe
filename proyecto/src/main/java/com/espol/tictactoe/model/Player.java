package com.espol.tictactoe.model;

public abstract class Player {
    private String name;
    protected Symbol symbol;

    public Player() {
    }

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }


}
