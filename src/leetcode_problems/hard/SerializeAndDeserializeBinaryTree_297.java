package leetcode_problems.hard;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree_297 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Time complexity: O(N). N -> number of nodes in a tree
    // Space complexity: O(N + M). N -> number of nodes in a tree, M -> total length of result string
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = q.removeFirst();
                if(curr != root) res.append(",");

                if(curr == null) res.append("N");
                else res.append(curr.val);

                if(curr != null) {
                    q.addLast(curr.left);
                    q.addLast(curr.right);
                }
            }
        }
        return res.toString();
    }

    // Time complexity: O(M + N). N -> number of nodes in a tree
    // Space complexity: O(N + M). N -> number of nodes in a tree, M -> length of the data string
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;

        while (!q.isEmpty() && idx < values.length) {
            TreeNode node = q.poll();
            Integer leftValue = values[idx].equals("N") ? null : Integer.valueOf(values[idx]);
            Integer rightValue = values[idx + 1].equals("N") ? null : Integer.valueOf(values[idx + 1]);

            if (leftValue != null) {
                node.left = new TreeNode(leftValue);
                q.offer(node.left);
            }
            if (rightValue != null) {
                node.right = new TreeNode(rightValue);
                q.offer(node.right);
            }
            idx += 2;
        }
        return root;
    }
}
