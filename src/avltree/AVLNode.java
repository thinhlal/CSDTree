
package avltree;

public class AVLNode<E> {
    E value;
    int height;
    AVLNode<E> left, right;
 
    AVLNode(E value) {
        this.value = value;
        this.height = 1;
        this.left = this.right = null;
    }
}
