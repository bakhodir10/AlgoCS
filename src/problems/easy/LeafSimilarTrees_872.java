package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = getLeaves(root1, new ArrayList<>());
        List<Integer> list2 = getLeaves(root2, new ArrayList<>());
        return list1.equals(list2);
    }

    private List<Integer> getLeaves(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        if (root.left == null && root.right == null) list.add(root.val);
        getLeaves(root.left, list);
        getLeaves(root.right, list);
        return list;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
