package com.espol.tictactoe.model;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import com.espol.tictactoe.controller.GamePlay;

public class Human extends Player{
    
    public Human() {
        super();
    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }

    @Override
    public void play(Player opponentPlayer, GamePlay gamePlay) {
        boolean canPlay = super.canPlay(gamePlay.getMatrix());
        if (!canPlay) {
            gamePlay.checkWinners();
            return;
        }

        GridPane board = gamePlay.getBoard();
        gamePlay.setSymbolOnHover(this.symbol);
        gamePlay.setPlayerTurn(this);
        gamePlay.clearBestPlay();

        board.setOnMouseClicked(e -> {
            Node node = (Node) e.getTarget();
            Node parent = node.getParent();

            Integer rowIndex = GridPane.getRowIndex(parent);
            Integer colIndex = GridPane.getColumnIndex(parent);
            int row = rowIndex == null ? 0 : rowIndex;
            int column = colIndex == null ? 0 : colIndex;

            Matrix newMatrix = gamePlay.getMatrix().copy();
            newMatrix.setSymbol(row, column, this.symbol);
            gamePlay.setMatrix(newMatrix);
            gamePlay.rePaint();
            opponentPlayer.play(this, gamePlay);
        });
    }
}
