package com.espol.tictactoe.model;

public class GameData {
    private GameMode gameMode;
    private Player playerOne;
    private Player playerTwo;
    private Symbol startingSymbol;

    public GameData() {
        this.gameMode = null;
        this.playerOne = null;
        this.playerTwo = null;
        this.startingSymbol = null;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public Symbol getStartingSymbol() {
        return startingSymbol;
    }

    public void setStartingSymbol(Symbol startingSymbol) {
        this.startingSymbol = startingSymbol;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "gameMode=" + gameMode +
                ", playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                ", startingSymbol=" + startingSymbol +
                '}';
    }
}
