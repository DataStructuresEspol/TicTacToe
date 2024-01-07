package librariesOwn;

import java.util.ArrayList;
import java.util.List;

class TreeNode<E> {
    
    private E content;
    private List<Tree<E>> children;

    public TreeNode(E content) {
        this.content = content;
        this.children = new ArrayList<>();
        this.children = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(int index, Tree<E> treeHijo) {
        this.children.get(index).setRoot(treeHijo.getRoot());
    }

    @Override
    public String toString() {
        return "TreeNode{" + "content=" + content + ", children=" + children + '}';
    }
    
    
    
    
}
