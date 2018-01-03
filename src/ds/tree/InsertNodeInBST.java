package ds.tree;

public class InsertNodeInBST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        root = insertHelper(root, elem);
    }

    private TreeNode<E> insertHelper(TreeNode<E> n, E elem) {
        if (n == null) return new TreeNode<>(elem);
        if (n.elem.compareTo(elem) > 0) n.left = insertHelper(n.left, elem);
        if (n.elem.compareTo(elem) < 0) n.right = insertHelper(n.right, elem);
        return n;
    }

    private class TreeNode<E> {
        private E elem;
        private TreeNode<E> left, right;

        public TreeNode(E elem) {
            this.elem = elem;
        }

        public TreeNode(E elem, TreeNode<E> left, TreeNode<E> right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }
    }
}
