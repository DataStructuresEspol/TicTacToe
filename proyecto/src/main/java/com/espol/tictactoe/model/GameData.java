package com.espol.tictactoe.model;

import com.espol.tictactoe.ds.Tree;
import com.espol.tictactoe.logic.GameMode;

public class GameData {
    private GameMode gameMode;
    private Player playerOne;
    private Player playerTwo;
    private Symbol startingSymbol;
    private Tree<Matrix> tree;

    public GameData() {
        this.gameMode = null;
        this.playerOne = null;
        this.playerTwo = null;
        this.startingSymbol = null;
        this.tree = new Tree<>(new Matrix());
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

    public void setGameData(GameData gameData) {
        this.gameMode = gameData.getGameMode();
        this.playerOne = gameData.getPlayerOne();
        this.playerTwo = gameData.getPlayerTwo();
        this.startingSymbol = gameData.getStartingSymbol();
        this.tree = gameData.getTree();
    }

    public Tree<Matrix> getTree() {
        return tree;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "gameMode=" + gameMode +
                ", playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                ", startingSymbol=" + startingSymbol +
                ", tree=" + tree +
                '}';
    }
}
