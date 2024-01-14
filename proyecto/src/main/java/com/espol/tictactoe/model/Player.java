package com.espol.tictactoe.model;

import javafx.scene.layout.GridPane;

import com.espol.tictactoe.controller.GamePlay;

public abstract class Player {
    private String name;
    protected Symbol symbol;

    public Player() {
    }

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public abstract String toString();

    public abstract void makePlay(GridPane board, GamePlay gamePlay);
}
