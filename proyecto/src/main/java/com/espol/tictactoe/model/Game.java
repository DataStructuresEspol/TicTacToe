
package com.espol.tictactoe.model;


public class Game {
   
    public static boolean win(Matrix m, Symbol s){
        return false;
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

}
