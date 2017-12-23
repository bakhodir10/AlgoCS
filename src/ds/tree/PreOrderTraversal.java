package ds.tree;

public class PreOrderTraversal<T extends Comparable> {
    private TreeNode root;

    public void insert(T elem) {
        TreeNode newNode = new TreeNode(elem);
        if (root == null) root = newNode;
        put(root, newNode);
    }

    @SuppressWarnings("unchecked")
    private void put(TreeNode n, TreeNode newNode) {
        if (n == null) return;
        if (n.elem.compareTo(newNode.elem) > 0) {
            if (n.left != null) put(n.left, newNode);
            else n.left = newNode;
        } else if (n.elem.compareTo(newNode.elem) < 0) {
            if (n.right != null) put(n.right, newNode);
            else n.right = newNode;
        }
    }

    public void traverse() {
        print(root);
    }

    private void print(TreeNode node) {
        if (node == null) return;
        System.out.print(node.elem + " ");
        if (node.left != null) print(node.left);
        if (node.right != null) print(node.right);
    }

    private class TreeNode {
        private T elem;
        private TreeNode left, right;

        public TreeNode(T elem) {
            this.elem = elem;
        }

        public TreeNode(T elem, TreeNode left, TreeNode right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }
    }
}
