package leetcode_problems.easy;

import java.util.LinkedList;
import java.util.List;

public class TwoSumBST_653 {
    List<Integer> list = new LinkedList<>();

    public boolean findTarget(TreeNode n, int k) {
        makeList(n);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            TreeNode f = find(n, k - list.get(i));
            if (f != null && list.get(i) != f.val) return true;
        }
        return false;
    }

    private void makeList(TreeNode n) {
        if (n == null) return;
        if (n.left != null) makeList(n.left);
        list.add(n.val);
        makeList(n.right);
    }

    private TreeNode find(TreeNode n, int val) {
        if (n == null) return null;
        if (n.val == val) return n;
        if (n.val > val) return find(n.left, val);
        else return find(n.right, val);
    }

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
