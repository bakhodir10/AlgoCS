package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBST_449 {

    // Time complexity: O(n). Space complexity: (n)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        List<String> list = new ArrayList<>();
        preOrder(root, list);
        return String.join(",", list);
    }

    private void preOrder(TreeNode root, List<String> list) {
        if (root != null) {
            list.add(String.valueOf(root.val));
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    // Time complexity: O(n). Space complexity: (n)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;

        String[] arr = data.split(",");
        TreeNode root = null;

        for (String s : arr) root = buildTree(root, Integer.parseInt(s));
        return root;
    }

    private TreeNode buildTree(TreeNode n, int val) {
        if (n == null) return new TreeNode(val);
        if (n.val > val) n.left = buildTree(n.left, val);
        if (n.val < val) n.right = buildTree(n.right, val);

        return n;
    }

    private static class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}