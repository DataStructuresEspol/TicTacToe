package com.espol.tictactoe.ds;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Tree<E> {
    
    private TreeNode<E> root;
    
    public Tree (E e) {
        this.root = new TreeNode<>(e); 
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public E getRoot() {
        return root.getContent();
    }
    
    public void setRoot (E content) {
        this.root.setContent(content);
    }
    
    public List<Tree<E>> getChildren() {
        return root.getChildren();
    }
    
    public void setChildren(int index, Tree<E> treeHijo) {
        List<Tree<E>> children = root.getChildren();
        while (children.size() <= index) {
            children.add(null);
        }
        children.set(index, treeHijo);
    }
    
    public boolean isLeaf () {
        return this.root.getChildren().isEmpty();
    }
    
    public void addChildren(E e){
        Tree<E> arbol = new Tree<>(e);
        if (!root.getChildren().contains(arbol)) {
            root.getChildren().add(arbol);
        }
    }
    
    public void recorrido(){
        Queue<TreeNode<E>> pr = new ArrayDeque<>();
        pr.offer(root);
        TreeNode<E> nodoTmp;
        while(!pr.isEmpty()){
            nodoTmp = pr.poll();
            System.out.println(nodoTmp);
            for(int i=0; i<nodoTmp.getChildren().size(); i++){
                pr.offer(nodoTmp.getChildren().get(i).root);
            }
        }
    }

    @Override
    public String toString() {
        return "Tree{" + "root=" + root + '}';
    }
    
    
    
}