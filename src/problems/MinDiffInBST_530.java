package problems;

import java.util.LinkedList;
import java.util.List;

public class MinDiffInBST_530 {
    List<TreeNode> list = new LinkedList<>();

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        inOrderTraverse(root);
        for (int i = 1; i < list.size(); i++) {
            int val = Math.abs(list.get(i).val - list.get(i - 1).val);
            if (val < min) min = val;
        }
        return min;
    }

    private void inOrderTraverse(TreeNode n) {
        if (n == null) return;
        if (n.left != null) inOrderTraverse(n.left);
        list.add(n);
        if (n.right != null) inOrderTraverse(n.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
