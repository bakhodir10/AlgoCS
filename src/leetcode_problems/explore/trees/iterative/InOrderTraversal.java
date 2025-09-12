package leetcode_problems.explore.trees.iterative;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();
        if (root == null) return inOrderList;
        Stack<TreeNode> nodeStack = new Stack<>();

        while (!nodeStack.isEmpty() || root != null) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            TreeNode lastNode = nodeStack.pop();
            inOrderList.add(lastNode.val);
            root = lastNode.right;
        }
        return inOrderList;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
