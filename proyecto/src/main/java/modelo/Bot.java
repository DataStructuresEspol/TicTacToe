
package modelo;
import librariesOwn.Tree;

public class Bot {
    private Symbol symbol;
    
    public Bot(Symbol symbol){
        this.symbol = symbol;
    }
    
    public Matrix makeDecition(Matrix matrix, Symbol oponentSymbol){
        int max = -100;
        int decition = 0;
        Tree<Matrix> tree = new Tree<>(matrix);
        thinkNextPlays(tree, symbol);
        for (Tree<Matrix> t: tree.getChildren()){
            thinkNextPlays(t, oponentSymbol);
            for (int i=0; i<t.getChildren().size(); i++){
                Matrix m = t.getChildren().get(i).getRoot();
                int utility = m.calculateUtility(oponentSymbol);
                //System.out.println(m);
                //System.out.println(utility);
                if (max < utility){
                    max = utility;
                    decition = i;
                }
            }
        }
        return tree.getChildren().get(decition).getRoot();
    }
    
    private void thinkNextPlays(Tree<Matrix> tree, Symbol symbol){
        Matrix matrix = tree.getRoot();
        int children = 0;
        
        for (int i=0; i<matrix.getPlay().length; i++){
            for (int j=0; j<matrix.getPlay()[i].length; j++){
                
                if (matrix.getPlay()[i][j].equals(Symbol.EMPTY)){
                    
                    Matrix m = matrix.copy();
                    
                    m.getPlay()[i][j] = symbol;
                    tree.addChildren(m);
                }
            }
        }
    }
}
