package binarysearchtree;

import binarytree.BinaryTree;
import binarytree.Node;

public class BST<E extends Comparable<E>> extends BinaryTree<E> {

    public BST() {
    }
    
    public Node<E> insert(Node<E> root, E key) throws Exception {
        if (root == null) {
            root = new Node(key);
            return root;
        } else if (key.compareTo(root.value) == 0) {
            throw new Exception("This key already exits");
        } else if (key.compareTo(root.value) > 0) {
            root.right = insert(root.right, key);
        } else if (key.compareTo(root.value) < 0) {
            root.left = insert(root.left, key);
        }
        return root;
    }

    public Node<E> insert(E key) throws Exception {
        this.root = this.insert(this.root, key);
        return this.root;
    }

    public Node<E> insert1(Node<E> root, E key) {
        Node<E> newNode = new Node(key);
        if (root == null) {
            return newNode;
        } else {
            Node<E> tmp = root;
            while (true) {
                if (newNode.value.compareTo(tmp.value) > 0) {
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
    public void inserts2(E... keys) throws Exception{
        for (E key : keys) {
            this.root = this.insert(this.root, key);
        }
    }
    public Node<E> search(Node<E> root, E key) {
        if (root == null) {
            return null;
        } else if (key.compareTo(root.value) == 0) {
            return root;
        } else if (key.compareTo(root.value) > 0) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }
    public void delete(E key) {
        this.root = this.delete(this.root, key);
    }

    public Node<E> delete(Node<E> root, E key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.value) < 0) {
            root.left = delete(root.left, key);
        } else if (key.compareTo(root.value) > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = findSuccessor(root).value;
            root.right = delete(root.right, root.value);
        }
        return root;
    }

    private Node<E> findSuccessor(Node<E> root) {
        Node<E> p = root.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}
