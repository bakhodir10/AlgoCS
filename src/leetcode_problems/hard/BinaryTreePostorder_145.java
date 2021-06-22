package leetcode_problems.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorder_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> postOrderList = new LinkedList<>();

        if (root == null) return postOrderList;
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            TreeNode top = nodeStack.pop();
            postOrderList.addFirst(top.val);
            if (top.left != null) nodeStack.push(top.left);
            if (top.right != null) nodeStack.push(top.right);
        }
        return postOrderList;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}