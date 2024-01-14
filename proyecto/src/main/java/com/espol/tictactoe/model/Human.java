package com.espol.tictactoe.model;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import com.espol.tictactoe.controller.GamePlay;

public class Human extends Player{
    
    public Human() {
    }
    public Human(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void makePlay(GridPane board, GamePlay gamePlay) {
        for (Node node: board.getChildren()) {
            int row = GridPane.getRowIndex(node) == null ? 0 : GridPane.getRowIndex(node);
            int col = GridPane.getColumnIndex(node) == null ? 0 : GridPane.getColumnIndex(node);

            VBox vBox = (VBox) node;
            vBox.setOnMouseClicked(e -> {
                Matrix m = gamePlay.getMatrix();
                m.getPlay()[row][col] = this.symbol;
                gamePlay.setMatrix(m);
                gamePlay.setSymbol(this.symbol, row, col);
                vBox.setDisable(true);
            });
        }
    }
}
