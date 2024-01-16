package com.espol.tictactoe.model;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.ds.Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.util.Duration;

public class Bot extends Player{
    public Bot() {
        super();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public Bot(Symbol symbol){
        super("Bot", symbol);
    }

    public Matrix makeDecition(Matrix matrix, Symbol oponentSymbol){
        List<Integer> utilidades = new ArrayList<>();
        List<Integer> u = new ArrayList<>();
        if (matrix.size() == 8){
            finalDecision(matrix);
            return matrix;
        }
        Tree<Matrix> tree = new Tree<>(matrix);
        thinkNextPlays(tree, symbol);
        for (Tree<Matrix> t: tree.getChildren()){
            
            thinkNextPlays(t, oponentSymbol);
            u.clear();
            for (int i=0; i<t.getChildren().size(); i++){
                Matrix m = t.getChildren().get(i).getRoot();
                int utility = m.calculateUtility(symbol);
                u.add(utility);
            }
            utilidades.add(Collections.min(u));
        }
        int max = Collections.max(utilidades);
        return tree.getChildren().get(utilidades.indexOf(max)).getRoot();
    }
    
    private void thinkNextPlays(Tree<Matrix> tree, Symbol symbol){
        Matrix matrix = tree.getRoot();
        for (int i=0; i<matrix.getPlay().length; i++){
            for (int j=0; j<matrix.getPlay()[i].length; j++){
                if (matrix.getPlay()[i][j].equals(Symbol.EMPTY)){
                    Matrix m = matrix.copy();
                    
                    m.getPlay()[i][j] = symbol;
                    tree.addChildren(m);
                }
            }
        }
    }
    
    private void finalDecision(Matrix matrix){
        for (int i=0; i<matrix.getPlay().length; i++){
            for (int j=0; j<matrix.getPlay()[i].length; j++){
                if (matrix.getPlay()[i][j].equals(Symbol.EMPTY)){matrix.getPlay()[i][j] = symbol;}
            }
        }
    }

    @Override
    public void play(Player opponentPlayer, GamePlay gamePlay) {
        boolean canPlay = super.canPlay(gamePlay.getMatrix());
        if (!canPlay) {
            gamePlay.checkWinners();
            return;
        }

        Matrix matrix = gamePlay.getMatrix();
        Matrix newMatrix = makeDecition(matrix, opponentPlayer.getSymbol());
        gamePlay.setMatrix(newMatrix);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            Platform.runLater(gamePlay::rePaint);
            opponentPlayer.play(this, gamePlay);
        });
        pause.play();
    }
}
