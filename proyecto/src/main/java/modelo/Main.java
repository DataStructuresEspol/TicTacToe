
package modelo;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Game game = new Game();
        Bot bot = new Bot(Symbol.X);
        Scanner s = new Scanner(System.in);
        
        Matrix matrix = new Matrix();
        //matrix.getPlay()[0][0] = Symbol.X;
        //matrix.getPlay()[0][1] = Symbol.O;
        //matrix.getPlay()[0][2] = Symbol.X;
        //matrix.getPlay()[1][0] = Symbol.O;
        //matrix.getPlay()[1][1] = Symbol.X;
        //matrix.getPlay()[2][0] = Symbol.X;
        //matrix.getPlay()[2][1] = Symbol.O;
        //matrix.getPlay()[2][2] = Symbol.O;
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
