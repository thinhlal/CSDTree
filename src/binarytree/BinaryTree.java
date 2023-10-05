package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {

    public Node<E> root;

    public void NLR(Node<E> root) {
        if (root != null) {
            System.out.printf("%s ", root.value);
            NLR(root.left);
            NLR(root.right);
        }
    }

    public void NLR() {
        this.NLR(this.root);
    }

    public void LNR(Node<E> root) {
        if (root != null) {
            LNR(root.left);
            System.out.printf("%s ", root.value);
            LNR(root.right);
        }
    }

    public void LNR() {
        this.LNR(this.root);
    }

    public void LRN(Node<E> root) {
        if (root != null) {
            LRN(root.left);
            LRN(root.right);
            System.out.printf("%s ", root.value);
        }
    }

    public void LRN() {
        this.LRN(this.root);
    }

    public void RNL(Node<E> root) {
        if (root != null) {
            RNL(root.right);
            System.out.printf("%s ", root.value);
            RNL(root.left);
        }
    }

    public void RNL() {
        this.RNL(this.root);
        System.out.println();
    }

    public void show(Node<E> root, String prefix, String childrenPrefix) {
        if (root == null) {
            return;
        }
        System.out.printf("%s%s\n", prefix, root.value);
        if (root.right == null) {
            show(root.left, childrenPrefix + "L--", childrenPrefix + "   ");
        } else {
            show(root.left, childrenPrefix + "L--", childrenPrefix + "|  ");
            show(root.right, childrenPrefix + "R--", childrenPrefix + "   ");
        }
    }

    public void show() {
        this.show(this.root, "", "");
    }

    public void BFT() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node<E> currentNode = q.poll();
            if (currentNode.left != null) {
                q.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                q.offer(currentNode.right);
            }
            System.out.printf("%s ", currentNode.value);
        }
        System.out.println();
    }

    /*K can thiet
    public void BFT() {
        this.BFT(this.root);
    }*/
    //Sua lai ham in ra node tai lv VD node 10 lv 0
    public void BFT(int level) {
        if (root == null) {
            return;
        }
        int cnt = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node<E> currentNode = q.poll();
            if (currentNode.left != null) {
                q.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                q.offer(currentNode.right);
            }
            System.out.printf("%s ", currentNode.value);
        }
        System.out.println();
    }
}
