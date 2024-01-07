
package modelo;


public class Board {
    private Matrix matrix;
    
    public Board(){this.matrix = new Matrix();}
    
    public Matrix getBoard(){
        return this.matrix;
    }
    
    public void setValue(Matrix matrix){
        this.matrix = matrix;
    }
    
    public boolean isFull(){
        int size = 0;
        int e = 0;

        Symbol[][] play = this.matrix.getPlay();

        for (int i = 0; i < play.length; i++) {
            for (int j = 0; j < play[i].length; j++) {
                size++;
                if (!play[i][j].equals(Symbol.EMPTY)) e++;
            }
        }

        return e == size;
    }
}
