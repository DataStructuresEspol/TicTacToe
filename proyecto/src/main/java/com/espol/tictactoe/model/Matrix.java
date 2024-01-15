
package com.espol.tictactoe.model;

import java.io.Serializable;

public class Matrix implements Serializable{
    private Symbol[][] play;
    
    public Matrix(){
        play = new Symbol[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){play[i][j] = Symbol.EMPTY;}
        }
    }
    public int calculateUtility(Symbol player){
        Symbol opponent = (player == Symbol.X) ? Symbol.O : Symbol.X;
        int playerWays = countWaysToWin(play, opponent);
        int opponentWays = countWaysToWin(play, player);
        return playerWays - opponentWays;
    }

    private static int countWaysToWin(Symbol[][] play, Symbol opponent) {
        int waysToWin = 0;

        for (int i = 0; i < 3; i++) {
            if (play[i][0] != opponent && play[i][1] != opponent && play[i][2] != opponent) {
                waysToWin++;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (play[0][j] != opponent && play[1][j] != opponent && play[2][j] != opponent) {
                waysToWin++;
            }
        }

        if (play[0][0] != opponent && play[1][1] != opponent && play[2][2] != opponent) {
            waysToWin++;
        }

        if (play[0][2] != opponent && play[1][1] != opponent && play[2][0] != opponent) {
            waysToWin++;
        }

        return waysToWin;
    }
    
    public Symbol[][] getPlay(){
        return this.play;
    }
    
    public Matrix copy(){
        Matrix m = new Matrix();
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){m.getPlay()[i][j] = play[i][j];}
        }
        return m;
    }
    
    public String toString(){
        String s = "";
        for (int i=0; i<3; i++){
            s+= "\n";
            for (int j=0; j<3; j++){
                s += " "+play[i][j].toString();
            }
        }
        return s;
    }
    
    public int size(){
        int size = 0;

        for (int i = 0; i < play.length; i++) {
            for (int j = 0; j < play[i].length; j++) {
                if (!play[i][j].equals(Symbol.EMPTY)) size++;
            }
        }

        return size;
    }

    public void setSymbol(int i, int j, Symbol symbol){
        play[i][j] = symbol;
    }
}
