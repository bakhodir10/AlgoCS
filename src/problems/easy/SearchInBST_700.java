package problems.easy;

public class SearchInBST_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val > val) return searchBST(root.left, val);
        else if (root.val < val) return searchBST(root.right, val);
        else return root;
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
