package ds.tree;


import java.util.LinkedList;
import java.util.List;

public class BST<T extends Comparable> implements Tree<T> {

    private TreeNode root;
    private List<T> list = new LinkedList<>();

    @Override
    public void insert(T elem) {
        TreeNode newNode = new TreeNode(elem);
        if (root == null) root = newNode;
        put(root, newNode);
    }

    @SuppressWarnings("unchecked")
    private void put(TreeNode n, TreeNode newNode) {
        if (n.elem.compareTo(newNode.elem) > 0) {
            if (n.left == null) n.left = newNode;
            else put(n.left, newNode);
        } else if (n.elem.compareTo(newNode.elem) < 0) {
            if (n.right == null) n.right = newNode;
            else put(n.right, newNode);
        }
    }

    @Override
    public boolean search(T elem) {
        return find(root, elem);
    }

    @SuppressWarnings("unchecked")
    private boolean find(TreeNode n, T elem) {
        if (n == null || elem == null) return false;
        if (n.elem.compareTo(elem) == 0) return true;
        if (n.elem.compareTo(elem) > 0) return find(n.left, elem);
        return find(n.right, elem);
    }

    @Override
    public void delete(T elem) {

    }

    @Override
    public void print() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode n) {
        if (n == null) return;
        if (n.left != null) inOrderTraversal(n.left);
        System.out.println(n.elem);
        if (n.right != null) inOrderTraversal(n.right);
    }

    public List<T> asList() {
        makeList(root);
        return list;
    }

    private void makeList(TreeNode n) {
        if (n == null) return;
        if (n.left != null) makeList(n.left);
        list.add(n.elem);
        if (n.right != null) makeList(n.right);
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
