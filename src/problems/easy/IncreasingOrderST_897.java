package problems.easy;

public class IncreasingOrderST_897 {

    private TreeNode head;
    private TreeNode nextNode;

    public TreeNode increasingBST(TreeNode root) {
        inOrderTraversal(root);
        return head;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);

        if (head == null) {
            head = new TreeNode(root.val);
            nextNode = head;
        } else {
            TreeNode toAdd = new TreeNode(root.val);
            nextNode.right = toAdd;
            nextNode = nextNode.right;
        }
        inOrderTraversal(root.right);
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
