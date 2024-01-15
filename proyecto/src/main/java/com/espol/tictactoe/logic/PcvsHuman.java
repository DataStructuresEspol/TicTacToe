package com.espol.tictactoe.logic;

import java.util.concurrent.CompletableFuture;

import javafx.scene.layout.GridPane;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.model.Bot;
import com.espol.tictactoe.model.Game;
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
//        Symbol startingSymbol = gameData.getStartingSymbol();
//        Player one = gameData.getPlayerOne();
//        Player two = gameData.getPlayerTwo();
//
//        boolean startsOne = startingSymbol.equals(one.getSymbol());
//
//        Player startingPlayer = startsOne ? one : two;
//        Player secondPlayer = startsOne ? two : one;
//        Player currentPlayer = startingPlayer;
//
//        boolean canPlay = true;
//
//        while (canPlay) {
//            gamePlay.setSymbolOnHover(currentPlayer.getSymbol());
//            CompletableFuture<Matrix> completableFuture = currentPlayer.makePlay(gamePlay);
//            Matrix matrix = completableFuture.join();
//            gamePlay.setMatrix(matrix);
//            gamePlay.paintMatrix(matrix);
//            canPlay = !Game.win(matrix, currentPlayer.getSymbol());
//            currentPlayer = currentPlayer.equals(startingPlayer) ? secondPlayer : startingPlayer;
//        }
    }
}
