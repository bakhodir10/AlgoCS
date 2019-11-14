package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class BTPaths_257 {
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return list;
        helper(root, "");
        return list;
    }

    private void helper(TreeNode root, String path) {
        if (root.left == null && root.right == null) list.add(path.concat(String.valueOf(root.val)));
        if (root.left != null) helper(root.left, path.concat(String.valueOf(root.val)).concat("->"));
        if (root.right != null) helper(root.right, path.concat(String.valueOf(root.val)).concat("->"));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
