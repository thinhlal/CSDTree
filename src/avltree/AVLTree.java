package avltree;

public class AVLTree<E extends Comparable<E>> {

    AVLNode<E> root;

    int height(AVLNode<E> N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public AVLNode<E> rightRotation(AVLNode<E> T) {
        AVLNode<E> T1 = T.left;
        AVLNode<E> R1 = T1.right;

        // Perform rotation
        T1.right = T;
        T.left = R1;

        // Update heights
        T.height = max(height(T.left), height(T.right)) + 1;
        T1.height = max(height(T1.left), height(T1.right)) + 1;

        // Return new root
        return T1;
    }

    public AVLNode<E> leftRotation(AVLNode<E> T) {
        AVLNode<E> T1 = T.right;
        AVLNode<E> L1 = T1.left;

        // Perform rotation
        T1.left = T;
        T.right = L1;

        // Update heights
        T.height = max(height(T.left), height(T.right)) + 1;
        T1.height = max(height(T1.left), height(T1.right)) + 1;

        // Return new root
        return T1;
    }

    // Get Balance factor of node N
    int getBalance(AVLNode<E> N) {
        if (N == null) {
            return 0;
        }

//        return height(N.left) - height(N.right);
        return height(N.right) - height(N.left);
    }

    public AVLNode<E> insert(AVLNode<E> node, E value) {

        /* 1.  Perform the normal BST insertion */
        if (node == null) {
            return (new AVLNode<E>(value));
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insert(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insert(node.right, value);
        } else // Duplicate values not allowed
        {
            return node;
        }

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases 
        // Left Left Case
        if (balance < -1 && value.compareTo(node.left.value) < 0) {
            return rightRotation(node);
        }

        // Right Right Case
        if (balance > 1 && value.compareTo(node.right.value) > 0) {
            return leftRotation(node);
        }

        // Left Right Case
        if (balance < -1 && value.compareTo(node.left.value) > 0) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        // Right Left Case
        if (balance > 1 && value.compareTo(node.right.value) < 0) {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    AVLNode<E> minValueNode(AVLNode<E> node) {
        AVLNode<E> current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    AVLNode<E> deleteNode(AVLNode<E> root, E key) {
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than 
        // the root's key, then it lies in left subtree 
        if (key.compareTo(root.value) < 0) {
            root.left = deleteNode(root.left, key);
        } // If the key to be deleted is greater than the 
        // root's key, then it lies in right subtree 
        else if (key.compareTo(root.value) > 0) {
            root.right = deleteNode(root.right, key);
        } // if key is same as root's key, then this is the node 
        // to be deleted 
        else {

            // node with only one child or no child 
            if ((root.left == null) || (root.right == null)) {
                AVLNode<E> temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // No child case 
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case 
                {
                    root = temp; // Copy the contents of 
                }                                // the non-empty child 
            } else {

                // node with two children: Get the inorder 
                // successor (smallest in the right subtree) 
                AVLNode<E> temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node 
                root.value = temp.value;

                // Delete the inorder successor 
                root.right = deleteNode(root.right, temp.value);
            }
        }

        // If the tree had only one node then return 
        if (root == null) {
            return root;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE 
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether 
        // this node became unbalanced) 
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases 
        // Left Left Case 
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotation(root);
        }

        // Left Right Case 
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // Right Right Case 
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotation(root);
        }

        // Right Left Case 
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    public void show(AVLNode<E> root, String prefix, String childrenPrefix) {
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

    public void inserts2(E... values) {
        for (E value : values) {
            this.root = insert(this.root, value);
        }
    }

    public String path(E key) {
        return this.path(root, key);
    }

    //Tra ve duong di tu root den node chua key
    //Ex: 40->80->60
    private String path(AVLNode<E> root, E key) {
        if (root == null) {
            return null;
        } else if (key.compareTo(root.value) == 0) {
            return root.value.toString();
        } else if (key.compareTo(root.value) > 0) {
            return root.value.toString() + "->" + path(root.right, key);
        } else {
            return root.value.toString() + "->" + path(root.left, key);
        }
    }

}
