
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
            y = Integer.parseInt(s.nextLine());
            x = Integer.parseInt(s.nextLine());
            matrix.getPlay()[y][x] = Symbol.O;
            System.out.println(matrix);
            //c = s.nextLine();
            
        }
        //game.next(m);
        
        
       
        
        
        

        
        
    }
}
