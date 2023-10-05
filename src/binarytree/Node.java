
package binarytree;

public class Node<E> {
    //Node parent;
    public Node left;
    public Node right;
    public E value;

    public Node(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    
}
