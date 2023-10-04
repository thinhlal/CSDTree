package binarysearchtree;

public class Node<E extends Comparable<E>> implements Comparable<E>{

    Node right;
    Node left;
    E value;

    public Node(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(E value) {
        return this.value.compareTo(value);
    }

}
