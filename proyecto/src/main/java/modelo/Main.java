
package modelo;

public class Main {
    public static void main(String args[]){
        Game game = new Game();
        Bot bot = new Bot(Symbol.O);

        Matrix matrix = new Matrix();
        matrix.getPlay()[1][1] = Symbol.X;
        //game.next(m);
        System.out.println(matrix);
        matrix = bot.makeDecition(matrix, Symbol.X);
        matrix.getPlay()[0][1] = Symbol.X;
        System.out.println(matrix);
        System.out.println(matrix.calculateUtility(Symbol.O));
        //matrix.getPlay()[2][0] = Symbol.X;
        //System.out.println(matrix);
        //matrix = bot.makeDecition(matrix, Symbol.X);
        //System.out.println(matrix);
        //matrix.getPlay()[2][0] = Symbol.X;
        //System.out.println(matrix);

        //Matrix m = new Matrix();
        //m.getPlay()[1][1] = Symbol.X;
        
        //Matrix matrix = bot.makeDecition(game.getPlays(), Symbol.X);
        //System.out.println(matrix);
        
        

        
        
    }
}
