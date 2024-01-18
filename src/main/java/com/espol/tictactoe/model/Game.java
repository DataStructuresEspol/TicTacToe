package com.espol.tictactoe.model;

import com.espol.tictactoe.ds.Tree;
import com.espol.tictactoe.logic.GameMode;

public class Game {
    private GameMode gameMode;
    private Player playerOne;
    private Player playerTwo;
    private Symbol startingSymbol;
    private Tree<Matrix> tree;

    public Game() {
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

    public void setGameData(Game game) {
        this.gameMode = game.getGameMode();
        this.playerOne = game.getPlayerOne();
        this.playerTwo = game.getPlayerTwo();
        this.startingSymbol = game.getStartingSymbol();
        this.tree = game.getTree();
    }

    public Tree<Matrix> getTree() {
        return tree;
    }

    public static boolean win(Matrix m, Symbol s){
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((m.getPlay()[i][0].equals(s) && m.getPlay()[i][1].equals(s) && m.getPlay()[i][2].equals(s)) ||
                    (m.getPlay()[0][i].equals(s) && m.getPlay()[1][i].equals(s) && m.getPlay()[2][i].equals(s))) {
                return true;
            }
        }

        // Verificar diagonales
        return (m.getPlay()[0][0].equals(s) && m.getPlay()[1][1].equals(s) && m.getPlay()[2][2].equals(s)) ||
                (m.getPlay()[0][2].equals(s) && m.getPlay()[1][1].equals(s) && m.getPlay()[2][0].equals(s));
    }

    public static int[] recomendacion(Matrix m, Symbol s){
        Bot bot = new Bot(s);
        Symbol symbol = (s == Symbol.X) ? Symbol.O : Symbol.X;
        Matrix matrix = bot.makeDecition(m.copy(), symbol);
        int[] pos = new int[2];
        for (int i=0; i<matrix.getPlay().length; i++){
            for (int j=0; j<matrix.getPlay()[i].length; j++){
                if (!matrix.getPlay()[i][j].equals(m.getPlay()[i][j])){
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
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
