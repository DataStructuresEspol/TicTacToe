
package modelo;

import java.util.List;

public class Bot {
    private Symbols symbol;
    
    public Bot(Symbols symbol){
        this.symbol = symbol;
    }
    
    public Matrix makeDecition(Tree<Matrix> tree, Symbols oponentSymbol){
        int max = -100;
        int decition = 0;
        thinkNextPlays(tree, symbol);
        for (Tree<Matrix> t: tree.getChildren()){
            thinkNextPlays(t, oponentSymbol);
            for (int i=0; i<t.getChildren().size(); i++){
                int utility = t.getChildren().get(i).getRoot().calculateUtility(oponentSymbol);
                if (max < utility){
                    max = utility;
                    decition = i;
                }
            }
        }
        return tree.getChildren().get(decition).getRoot();
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
