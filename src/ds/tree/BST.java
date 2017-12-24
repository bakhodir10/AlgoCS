package ds.tree;

import java.util.LinkedList;
import java.util.List;

public class BST<E extends Comparable<E>> {

    private TreeNode<E> root;
    private List<E> list = new LinkedList<>();

    public void insert(E elem) {
        if (elem == null) return;
        TreeNode<E> newNode = new TreeNode<>(elem);
        if (root == null) root = newNode;
        insertHelper(root, newNode);
    }

    private void insertHelper(TreeNode<E> n, TreeNode<E> newNode) {
        if (n.elem.compareTo(newNode.elem) > 0) {
            if (n.left == null) n.left = newNode;
            else insertHelper(n.left, newNode);
        } else if (n.elem.compareTo(newNode.elem) < 0) {
            if (n.right == null) n.right = newNode;
            else insertHelper(n.right, newNode);
        }
    }

    public boolean find(E elem) {
        if (elem == null) return false;
        return findHelper(root, elem);
    }

    private boolean findHelper(TreeNode<E> n, E elem) {
        if (n == null) return false;
        if (n.elem.compareTo(elem) == 0) return true;
        if (n.elem.compareTo(elem) > 0) return findHelper(n.left, elem);
        return findHelper(n.right, elem);
    }

    public void delete(E elem) {
        if (elem == null) return;
        deleteHelper(root, root, elem);
    }

    private void deleteHelper(TreeNode<E> parent, TreeNode<E> n, E elem) {
        if (n == null) return; // the base case
        if (n.elem.compareTo(elem) > 0) deleteHelper(n, n.left, elem);
        else if (n.elem.compareTo(elem) < 0) deleteHelper(n, n.right, elem);
        else { // found, now let's remove it
            if (n.left == null && n.right == null) {   // case 1: if the node has no child
                deleteCase1(parent, n);
            } else if (n.left == null || n.right == null) {// case 2: if the node has only one child
                deleteCase2(parent, n);
            } else {  // case 3: if the node has two child
                deleteCase3(parent, n);
            }
        }
    }

    private void deleteCase1(TreeNode<E> parent, TreeNode<E> n) {
        System.out.println("case 1");
        if (parent.left.elem.compareTo(n.elem) == 0) parent.left = null;
        else parent.right = null;
    }

    private void deleteCase2(TreeNode<E> parent, TreeNode<E> n) {
        System.out.println("case 2");
        if (parent.left.elem.compareTo(n.elem) == 0)
            parent.left = n.left != null ? n.left : n.right;
        else parent.right = n.right != null ? n.right : n.left;
    }

    // todo not finished
    // 11 17 23 24 30 35 42 60 63 68 69 76 80, delete -> 17
    private void deleteCase3(TreeNode<E> parent, TreeNode<E> n) {
        System.out.println("case 3");
        TreeNode<E> minRight = minRightTraversal(n, n.left);
        System.out.println(parent.elem);
//        System.out.println(minRight.elem);
        parent.left.elem = minRight.right.elem;
        minRight.right = null;
    }

    private TreeNode<E> minRightTraversal(TreeNode<E> p, TreeNode<E> n) {
        if (n.right == null) return p;
        p = n;
        return minRightTraversal(p, n.right);
    }

    public void print() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode<E> n) {
        if (n == null) return;
        if (n.left != null) inOrderTraversal(n.left);
        System.out.print(n.elem + " ");
        if (n.right != null) inOrderTraversal(n.right);
    }

    public List<E> asList() {
        makeList(root);
        return list;
    }

    private void makeList(TreeNode<E> n) {
        if (n == null) return;
        if (n.left != null) makeList(n.left);
        list.add(n.elem);
        if (n.right != null) makeList(n.right);
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
