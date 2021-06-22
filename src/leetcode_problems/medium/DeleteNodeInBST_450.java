package leetcode_problems.medium;

public class DeleteNodeInBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        return deleteHelper(root, key);
    }

    private TreeNode deleteHelper(TreeNode node, int elem) {
        if (node == null) return node;
        if (node.val > elem) node.left = deleteHelper(node.left, elem);
        else if (node.val < elem) node.right = deleteHelper(node.right, elem);
        else {                                             // found, now let's remove it
            if (node.left == null && node.right == null) {
                node = null;                               // case 1: if the node has no child
            } else if (node.left == null || node.right == null) {
                if (node.left != null) node = node.left;   // case 2: if the node has only one child
                else node = node.right;
            } else {                                       // case 3: if the node has two child
                TreeNode p = findMin(node.left);
                node.val = p.val;
                node.left = deleteHelper(node.left, p.val);
            }
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private class TreeNode {
        private int val;
        private TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
