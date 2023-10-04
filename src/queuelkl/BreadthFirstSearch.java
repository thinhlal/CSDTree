package queuelkl;

import java.util.LinkedList;

import java.util.Queue;
public class BreadthFirstSearch {

    public static void BFT(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        if (!q.isEmpty()) {
            TreeNode currentNode = q.poll();
            System.out.println(currentNode.value + " ");
            if (currentNode.left != null) {
                q.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                q.offer(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Breadth-First Traversal:");
        BFT(root);
    }
}
