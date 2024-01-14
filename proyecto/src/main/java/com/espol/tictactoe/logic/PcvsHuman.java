package com.espol.tictactoe.logic;

import javafx.scene.layout.GridPane;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.model.Bot;
import com.espol.tictactoe.model.GameData;
import com.espol.tictactoe.model.Human;
import com.espol.tictactoe.model.Matrix;
import com.espol.tictactoe.model.Player;
import com.espol.tictactoe.model.Symbol;

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

    @Override
    public void play(GameData gameData, GamePlay gamePlay) {
        GridPane board = gamePlay.getBoard();
        Symbol startingSymbol = gameData.getStartingSymbol();
        Player one = gameData.getPlayerOne();
        Player two = gameData.getPlayerTwo();

        boolean startsOne = startingSymbol.equals(one.getSymbol());

        Player startingPlayer = startsOne ? one : two;
        Player secondPlayer = startsOne ? two : one;
        Player currentPlayer = startingPlayer;

        boolean canPlay = true;

        while (canPlay) {
            gamePlay.setSymbolOnHover(currentPlayer.getSymbol());
            currentPlayer.makePlay(board, gamePlay);
            currentPlayer = currentPlayer.equals(startingPlayer) ? secondPlayer : startingPlayer;
        }
    }
}
