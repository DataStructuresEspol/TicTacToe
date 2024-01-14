
package com.espol.tictactoe.model;

public class Game {
    
    public static boolean win(Matrix m, Symbol s){
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((m.getPlay()[i][0].equals(s) && m.getPlay()[i][1].equals(s) && m.getPlay()[i][2].equals(s)) ||
                (m.getPlay()[0][i].equals(s) && m.getPlay()[1][i].equals(s) && m.getPlay()[2][i].equals(s))) {
                return true;
            }
        }

        // Verificar diagonales
        if ((m.getPlay()[0][0].equals(s) && m.getPlay()[1][1].equals(s) && m.getPlay()[2][2].equals(s)) ||
            (m.getPlay()[0][2].equals(s) && m.getPlay()[1][1].equals(s) && m.getPlay()[2][0].equals(s))) {
            return true;
        }

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
