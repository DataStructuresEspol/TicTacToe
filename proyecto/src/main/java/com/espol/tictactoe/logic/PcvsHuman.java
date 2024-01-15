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
