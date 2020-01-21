package problems.medium;

import java.util.Stack;

public class KSmallestBST_230 {

    public int kthSmallest(TreeNode node, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty()) return -1;
            node = stack.pop();
            k--;
            if (k == 0) return node.val;
            node = node.right;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
