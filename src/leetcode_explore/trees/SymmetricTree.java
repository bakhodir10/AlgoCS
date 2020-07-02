package leetcode_explore.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {

    // approach 1. Recursive solution
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return false;
        return helper(root, root);
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }

    // approach 2. Iterative solution
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            else if (t1 == null || t2 == null) return false;
            else if (t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    // approach 3. Iterative solution
    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodeList.add(node);
                if (node != null) queue.offer(node.left);
                if (node != null) queue.offer(node.right);
            }
            if (!compareHelper(nodeList)) return false;
        }
        return true;
    }

    private boolean compareHelper(List<TreeNode> nodeList) {
        for (int i = 0; i < nodeList.size() / 2; i++) {
            TreeNode lNode = nodeList.get(i);
            TreeNode rNode = nodeList.get(nodeList.size() - i - 1);
            if (lNode == null && rNode == null) continue;
            else if (lNode == null || rNode == null) return false;
            else if (lNode.val != rNode.val) return false;
        }
        return true;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
