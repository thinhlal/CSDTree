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

    public void listNodeAtLevel(int level) {
        if (root == null) {
            return;
        }
        int cnt = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            if (cnt == level) {
                System.out.print("Level " + level + ": ");
                int currentSize = q.size();
                Node<E> currentNode;
                for (int i = 0; i < currentSize; i++) {
                    currentNode = q.poll();
                    System.out.printf("%s ", currentNode.value);
                }
                System.out.println();
                return;
            }
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                Node<E> currentNode = q.poll();
                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            }
            cnt++;
        }
        System.out.println("Level " + level + " does not exist in the tree.");
        return;
    }

    private void BFTRecursive(Queue<Node> q) {
        if (q.isEmpty()) {
            return;
        }

        Node<E> currentNode = q.poll();

        if (currentNode.left != null) {
            q.offer(currentNode.left);
        }
        if (currentNode.right != null) {
            q.offer(currentNode.right);
        }

        System.out.printf("%s ", currentNode.value);

        BFTRecursive(q);
    }

    public void BFTR(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);

        BFTRecursive(q);
    }

    public void BFTR() {
        this.BFTR(this.root);
    }

    public void listInternalNodes(Node<E> node) {
        if (node == null) {
            return;
        }

        if (node.left != null || node.right != null) {
            System.out.printf("%s ", node.value); // Print the value if it's an internal node
        }

        listInternalNodes(node.left);
        listInternalNodes(node.right);
    }

    public void listLeafNodes(Node<E> node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.printf("%s ", node.value);
        }

        listLeafNodes(node.left);
        listLeafNodes(node.right);
    }

    public boolean isProper(Node<E> node) {
        if (node == null) {
            return true;
        }

        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            return false;
        }

        return isProper(node.left) && isProper(node.right);
    }

    public boolean isComplete(Node<E> root) {
        if (root == null) {
            return true;
        }
        Queue<Node<E>> q = new LinkedList<>();
        q.offer(root);
        boolean lastLevelNode = false;
        while (!q.isEmpty()) {
            Node<E> curNode = q.poll();
            if (curNode == null) {
                lastLevelNode = true;
            } else {
                if (lastLevelNode) {
                    return false;
                }
                q.offer(curNode.left);
                q.offer(curNode.right);
            }
        }
        return true;
    }
    
    public boolean isComplete() {
        return this.isComplete(this.root);
    }
}
