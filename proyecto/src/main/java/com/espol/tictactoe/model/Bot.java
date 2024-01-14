

package com.espol.tictactoe.model;
import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.ds.Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.layout.GridPane;

public class Bot extends Player{
    public Bot() {
        super();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void makePlay(GridPane board, GamePlay gamePlay) {
        Matrix currentMatrix = gamePlay.getMatrix();
        Symbol opponentSymbol = this.getSymbol().equals(Symbol.X) ? Symbol.O : Symbol.X;
        Matrix newMatrix = makeDecition(currentMatrix, opponentSymbol);
        gamePlay.setMatrix(newMatrix);
        Platform.runLater(() -> {
            try {
                Thread.sleep(1000);
                gamePlay.paintMatrix(newMatrix);
            } catch (
                    InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
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
                //System.out.println(m);
                
                
            }
            //System.out.print("utilidades");
            //System.out.println(u);
            utilidades.add(Collections.min(u));
            
        }
        //System.out.println(utilidades);
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
}
