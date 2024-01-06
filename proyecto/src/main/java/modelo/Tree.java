
package modelo;

import java.util.List;


public class Tree<E> {
    private Node root;
    
    class Node<E>{
        private E content;
        private List<Tree<E>> children;
        
        public E getContent(){
            //TODO
            return null;
        }
        
        public List<Tree<E>> getChildren(){
            //TODO
            return null;
        }
    }
    
    public E getRoot(){
        //TODO
        return null;
    }
    
    public List<Tree<E>> getChildren(){
        //TODO
        return null;
    }
}
