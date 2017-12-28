package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals<E> {
    private TreeNode root;

    // all left -> parent -> right child
    private void inOrderTraversal(TreeNode n) {
        if (n == null) return;
        if (n.left != null) inOrderTraversal(n.left);
        System.out.print(n.elem + " ");
        if (n.right != null) inOrderTraversal(n.right);
    }

    // parent -> all left -> right child
    private void preOrderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.elem + " ");
        if (node.left != null) preOrderTraversal(node.left);
        if (node.right != null) preOrderTraversal(node.right);
    }

    // left -> right -> parent
    private void postOrderTraversal(TreeNode n) {
        if (n == null) return;
        if (n.left != null) postOrderTraversal(n.left);
        if (n.right != null) postOrderTraversal(n.right);
        System.out.println(n.elem);
    }

    // parent ->  left -> right child
    private void depthFirstTraversal(TreeNode n) {
        if (n == null) return;
        Queue<TreeNode> children = new LinkedList<>();
        children.add(root);
        while (!children.isEmpty()) {
            TreeNode node = children.poll();
            System.out.print(node.elem + " ");
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
        }
    }

    // parent -> right -> left child
    private void depthFirstTraversal2(TreeNode n) {
        if (n == null) return;
        Stack<TreeNode> children = new Stack<>();
        children.add(root);
        while (!children.isEmpty()) {
            TreeNode node = children.pop();
            System.out.print(node.elem + " ");
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
        }
    }

    private class TreeNode {
        private E elem;
        private TreeNode left, right;

        public TreeNode(E elem, TreeNode left, TreeNode right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

        public TreeNode(E elem) {
            this.elem = elem;
        }
    }
}
