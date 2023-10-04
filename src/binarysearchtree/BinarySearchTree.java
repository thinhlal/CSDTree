package binarysearchtree;

public class BinarySearchTree<E> {

    public Node insert1(Node root, E key) {
        Node newNode = new Node(key);
        if (root == null) {
            return newNode;
        } else {
            Node tmp = root;
            while (true) {
                if (newNode.compareTo(tmp.value) > 0) {
                    if (tmp.right == null) {
                        tmp.right = newNode;
                        break;
                    } else {
                        tmp = tmp.right;
                    }
                } else {
                    if (tmp.left == null) {
                        tmp.left = newNode;
                        break;
                    } else {
                        tmp = tmp.left;
                    }
                }
            }
        }
        return root;
    }

    public Node insert(Node root, E key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else if (key == root.value) {
            System.out.println("Exits node");
        } else if (key > root.value) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }
        return root;
    }

    public Node search(Node root, E key) {
        if (root == null) {
            return null;
        } else if (key == root.value) {
            return root;
        } else if (key > root.value) {
            return search(root.right, key);
        } else if (key < root.value) {
            return search(root.left, key);
        }
        return root;
    }
}
