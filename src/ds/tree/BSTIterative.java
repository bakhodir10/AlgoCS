package ds.tree;

import java.util.Stack;

public class BSTIterative<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        TreeNode<E> newNode = new TreeNode<>(elem);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode<E> parent = root, node = root;
        while (node != null) {
            parent = node;
            if (node.elem.compareTo(elem) > 0) node = node.left;
            else node = node.right;
        }
        if (parent.elem.compareTo(elem) > 0) parent.left = newNode;
        else parent.right = newNode;
    }

    public boolean find(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        if (root == null) throw new NullPointerException();
        TreeNode<E> node = root;
        while (true) {
            if (node == null) return false;
            if (node.elem.compareTo(elem) == 0) return true;
            if (node.elem.compareTo(elem) > 0) node = node.left;
            else node = node.right;
        }
    }

    public void print() {
        if (root == null) throw new NullPointerException();
        TreeNode<E> node = root;
        // inorder traversal
        Stack<TreeNode<E>> st = new Stack<>();
        st.push(root);
        while (node != null && !st.isEmpty()) {
            while (node.left != null) {
                node = node.left;
                st.push(node);
            }
            TreeNode<E> popped = st.pop();
            System.out.print(popped.elem + " ");
            if (popped.right != null) {
                st.push(popped.right);
                node = popped.right;
            }
        }
    }

    public E getMax() {
        if (root == null) throw new NullPointerException();
        TreeNode<E> node = root;
        while (node.right != null) node = node.right;
        return node.elem;
    }

    public E getMin() {
        if (root == null) throw new NullPointerException();
        TreeNode<E> node = root;
        while (node.left != null) node = node.left;
        return node.elem;
    }

    private class TreeNode<E> {
        private E elem;
        private TreeNode<E> left, right;

        public TreeNode(E elem) {
            this.elem = elem;
        }
    }
}
