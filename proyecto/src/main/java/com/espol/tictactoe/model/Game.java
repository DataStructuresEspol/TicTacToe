
package com.espol.tictactoe.model;
<<<<<<< HEAD

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
=======


public class Game {
   
    public static boolean win(Matrix m, Symbol s){
        return false;
    }
    
    public static int[] recomendacion(Matrix m, Symbol s){
        return null;
>>>>>>> a8a5798ab027c6b43ebc00df80ce672a4423fd90
    }

}
