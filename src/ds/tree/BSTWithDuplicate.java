package ds.tree;

/*
    support Binary Search Tree(BST) with duplicates elements
 */
public class BSTWithDuplicate<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E elem) {
        if (root == null) root = new TreeNode<>(elem);
        else insertHelper(root, elem);
    }

    private TreeNode<E> insertHelper(TreeNode<E> node, E elem) {
        if (node == null) return null;
        if (node.elem.compareTo(elem) > 0) {
            if (node.left != null) return insertHelper(node.left, elem);
            else node.left = new TreeNode<>(elem);
        } else if (node.elem.compareTo(elem) < 0) {
            if (node.right != null) return insertHelper(node.right, elem);
            else node.right = new TreeNode<>(elem);
        } else node.duplicateCount++;
        return node;
    }

    public void delete(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        root = deleteHelper(root, elem);
    }

    private TreeNode<E> deleteHelper(TreeNode<E> node, E elem) {
        if (node == null) return null;
        if (node.elem.compareTo(elem) > 0) node.left = deleteHelper(node.left, elem);
        if (node.elem.compareTo(elem) < 0) node.right = deleteHelper(node.right, elem);
        else if (node.elem.compareTo(elem) == 0) {
            // if there is duplicate of being deleted element, then just lower number of duplicate count
            if (node.duplicateCount > 1) node.duplicateCount--;
            else {
                if (node.left == null && node.right == null) node = null; // the node has no child
                else if (node.left == null || node.right == null) {       // the node has only one child
                    if (node.left != null) node = node.left;
                    else node = node.right;
                } else {                                                   // the node has two children
                    TreeNode<E> p = findMin(node.left);
                    node.elem = p.elem;
                    node.left = deleteHelper(node.left, p.elem);
                }
            }
        }
        return node;
    }

    private TreeNode<E> findMin(TreeNode<E> node) {
        while (node.right != null) node = node.right;
        return node;
    }

    public boolean find(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        return findHelper(root, elem) != null;
    }

    public void print() {
        printHelper(root);
    }

    private void printHelper(TreeNode<E> node) {
        if (node == null) return;
        if (node.left != null) printHelper(node.left);
        for (int i = 0; i < node.duplicateCount; i++) {
            System.out.print(node.elem + " ");
        }
        if (node.right != null) printHelper(node.right);
    }

    private TreeNode<E> findHelper(TreeNode<E> node, E elem) {
        if (node == null) return null;
        if (node.elem.compareTo(elem) == 0) return node;
        if (node.elem.compareTo(elem) > 0) return findHelper(node.left, elem);
        return findHelper(node.right, elem);
    }

    public int getCount(E elem) {
        TreeNode<E> n = findHelper(root, elem);
        return n != null ? n.duplicateCount : 0;
    }

    private class TreeNode<E> {
        private int duplicateCount; // duplicateCount of duplicate elements
        private E elem;
        private TreeNode<E> left, right;

        public TreeNode(E elem) {
            this.elem = elem;
            this.duplicateCount = 1;
        }
    }
}
