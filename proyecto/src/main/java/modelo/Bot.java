
package modelo;

import java.util.List;

public class Bot {
    private Symbols symbol;
    
    public Bot(Symbols symbol){
        this.symbol = symbol;
    }
    
    public Matrix makeDecition(Tree<Matrix> tree){
        //TODO
        return null;
    }
    
    private void thinkNextPlays(Tree<Matrix> tree, Symbols symbol){
        Matrix matrix = tree.getRoot();
        int children = 0;
        for (int i=0; i<matrix.getPlay().length; i++){
            for (int j=0; j<matrix.getPlay()[i].length; j++){
                if (matrix.getPlay()[i][j].equals(Symbols.EMPTY)){
                    Matrix m = matrix.copy();
                    m.getPlay()[i][j] = symbol;
                    tree.setChildren(children, new Tree(m));
                }
            }
        }
    }
}
