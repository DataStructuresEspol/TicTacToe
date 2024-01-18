package com.espol.tictactoe.model;

import com.espol.tictactoe.controller.GamePlay;

public abstract class Player {
    protected String name;
    protected Symbol symbol;

    public Player() {}

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

    public abstract void play(Player opponentPlayer, GamePlay gamePlay);

    public boolean canPlay(Matrix matrix){
        boolean xWon = Game.win(matrix, Symbol.X);
        boolean oWon = Game.win(matrix, Symbol.O);

        boolean isFull = Matrix.isFull(matrix);

        return !xWon && !oWon && !isFull;
    }
}
