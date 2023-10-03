package binarytree;

public class BinaryTree {

    public static Node createNode(Node root) {
        root = new Node<>(10);
        root.left = new Node<>(20);
        root.right = new Node<>(30);
        root.left.left = new Node<>(40);
        root.left.right = new Node<>(50);
        root.right.right = new Node<>(60);
        return root;
    }

    public static void NLR(Node root) {
        if (root != null) {
            System.out.println(root.value);
            NLR(root.left);
            NLR(root.right);
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = null;
        root = createNode(root);
        NLR(root);
    }
}