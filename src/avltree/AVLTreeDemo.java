package avltree;

import binarytree.BinaryTree;
import binarytree.Node;
import java.util.Random;

public class AVLTreeDemo {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static AVLTree<Integer> generate(int n) {
        AVLTree<Integer> avlt = new AVLTree<>();
        for (int i = 0; i < n; i++) {
            avlt.root = avlt.insert(avlt.root, RANDOM.nextInt());
        }
        return avlt;
    }

    public static void main(String[] args) throws Exception {
        AVLTree<Integer> a = generate(100);
        a.show();
    }
}
