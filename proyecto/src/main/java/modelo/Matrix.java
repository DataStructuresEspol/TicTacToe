
package modelo;


public class Matrix {
    private Symbol[][] play;
    
    public int calculateUtility(Symbol symbol){
        int playerWays = countWaysToWin(play, symbol);
        int opponentWays = countWaysToWin(play, (symbol == Symbol.X) ? Symbol.O : Symbol.X);

        return playerWays - opponentWays;
    }

    private static int countWaysToWin(Symbol[][] play, Symbol player) {
        int waysToWin = 0;

        for (int i = 0; i < 3; i++) {
            if (play[i][0] == player && play[i][1] == player && play[i][2] == player) {
                waysToWin++;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (play[0][j] == player && play[1][j] == player && play[2][j] == player) {
                waysToWin++;
            }
        }

        if (play[0][0] == player && play[1][1] == player && play[2][2] == player) {
            waysToWin++;
        }

        if (play[0][2] == player && play[1][1] == player && play[2][0] == player) {
            waysToWin++;
        }

        return waysToWin;
    }
    
    public Symbol[][] getPlay(){
        return this.play;
    }
    
    public Matrix copy(){
        //TODO
        return null;
    }
}
