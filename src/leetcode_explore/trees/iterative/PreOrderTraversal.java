package leetcode_explore.trees.iterative;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    // approach 1
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> preOrderList = new LinkedList<>();
        if (root == null) return preOrderList;

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            preOrderList.add(currentNode.val);
            if (currentNode.right != null) nodeStack.add(currentNode.right);
            if (currentNode.left != null) nodeStack.add(currentNode.left);
        }
        return preOrderList;
    }

    // approach 2
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> preOrderList = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        
        if (root == null) return preOrderList;

        while (!nodeStack.isEmpty() || root != null) {
            while (root != null) {
                preOrderList.add(root.val);
                root = root.left;
                nodeStack.add(root);
            }
            root = nodeStack.pop().right;
        }
        return preOrderList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}