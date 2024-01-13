
package modelo;
import ds.Tree;

public class Game {
    private Tree<Matrix> plays;
    private Board board;
    
    public Game(){
        board = new Board();
        plays = new Tree<Matrix>(new Matrix());
    }
    
    public void next(Matrix matrix){
        board.setValue(matrix);
    }
    
    public boolean win(){
        return board.isFull();
    }
    
    public Tree<Matrix> getPlays(){
        return plays;
    }
    
    public Board getBoard(){
        return board;
    }
}
