
package com.espol.tictactoe.model;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        //Gaz = new Game();
        Bot bot = new Bot(Symbol.X);
        Scanner s = new Scanner(System.in);
        
        Matrix matrix = new Matrix();
        int x, y;
        String c = "";
        while (!c.equals("No")){
            
            
            matrix = bot.makeDecition(matrix, Symbol.O);
            System.out.println(matrix);
            int[] rec = Game.recomendacion(matrix, Symbol.O);
            System.out.println("recomendacion"+rec[0]+" "+rec[1]);
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
