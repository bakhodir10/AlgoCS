package leetcode_problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDesc_2196 {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> allNodes = new HashMap<>();
        Set<Integer> parents = new HashSet<>();

        for (int[] d : descriptions) {
            allNodes.putIfAbsent(d[0], new TreeNode(d[0]));
            allNodes.putIfAbsent(d[1], new TreeNode(d[1]));
            parents.add(d[0]);
        }

        for (int[] d : descriptions) {
            TreeNode parent = allNodes.get(d[0]);
            TreeNode child = allNodes.get(d[1]);
            boolean isLeft = d[2] == 1;

            if (isLeft) parent.left = child;
            else parent.right = child;

            parents.remove(d[1]);
        }
        return allNodes.get(parents.iterator().next());
    }
}
