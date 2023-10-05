package binarytree;

import java.util.Random;

public class BinaryTreeDemo {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static BinaryTree<Integer> create() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new Node<>(10);
        tree.root.left = new Node<>(20);
        tree.root.right = new Node<>(30);

        tree.root.left.left = new Node<>(40);
        tree.root.left.right = new Node<>(50);

        tree.root.right.right = new Node<>(60);
        return tree;
    }

    public static Node generate(Node p, int k) {
        p = new Node(RANDOM.nextInt(100));
        if (k > 0) {
            int n = RANDOM.nextInt(10);
            if (n < 6) {
                p.left = generate(p.left, k - 1);
                p.right = generate(p.right, k - 1);
            } else if (n < 8) {
                p.left = generate(p.left, k - 1);
            } else {
                p.right = generate(p.right, k - 1);
            }
        }
        return p;
    }

    public static BinaryTree<Integer> generate(int level) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = generate(tree.root, level);
        return tree;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = generate(5);
        tree.BFT();
        tree.show();

    }
}
