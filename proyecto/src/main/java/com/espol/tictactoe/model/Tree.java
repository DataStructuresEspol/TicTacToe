
package com.espol.tictactoe.model;

import java.util.List;


public class Tree<E> {
    private Node root;
    
    public Tree(E e){
        //TODO
    }
    
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
        
        public void setChildren(int index, Tree<E> tree){
        //TODO
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
    
    public void setChildren(int index, Tree<E> tree){
        //TODO
    }
    
    public boolean isLeaf(){
        return false;
    }
}
