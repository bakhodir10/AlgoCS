package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSumII_113 {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return list;
        helper(root, "", sum);
        return list;
    }

    private void helper(TreeNode root, String path, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path = path.concat(String.valueOf(root.val));
                String[] strs = path.split(" ");
                Integer[] nums = new Integer[strs.length];
                for (int i = 0; i < strs.length; i++) nums[i] = Integer.parseInt(strs[i]);
                list.add(Arrays.asList(nums));
            }
        }

        if (root.left != null) {
            helper(root.left, path.concat(String.valueOf(root.val)).concat(" "), sum - root.val);
        }
        if (root.right != null) {
            helper(root.right, path.concat(String.valueOf(root.val)).concat(" "), sum - root.val);
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
