
package com.espol.tictactoe.model;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
<<<<<<< HEAD
=======
        //Gaz = new Game();
>>>>>>> a8a5798ab027c6b43ebc00df80ce672a4423fd90
        Bot bot = new Bot(Symbol.X);
        Scanner s = new Scanner(System.in);
        
        Matrix matrix = new Matrix();
        int x, y;
        String c = "";
        while (!c.equals("No")){
            
            
            matrix = bot.makeDecition(matrix, Symbol.O);
            System.out.println(matrix);
            y = Integer.parseInt(s.nextLine());
            x = Integer.parseInt(s.nextLine());
            matrix.getPlay()[y][x] = Symbol.O;
            System.out.println(matrix);
            //c = s.nextLine();
            
        }
        //if(Game.win(matrix, Symbol.X)) System.out.println("Gano X");
        //else System.out.println("Gano O");
        
        //game.next(m);
        
        
        
        
    }
}
