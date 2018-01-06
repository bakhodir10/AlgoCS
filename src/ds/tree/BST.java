package ds.tree;

import java.util.LinkedList;
import java.util.List;

/*
    Time complexity:
    Building binary tree:
     Best case: O(logN)
     Worst case: O(N2)

     Best case:
      Searching element: O(logN)
      Adding element: O(logN)   -> to add, find new element position where belongs to
      Delete element: O(logN)   -> to add, find new element position where belongs to
     Worst case:
      Searching element: O(N) -> in case binary tree is very tall and every element only one child
      Adding element: O(N)    -> to add, find new element position where belongs to and searching takes O(N)
      Delete element: O(N)    -> to add, find new element position where belongs to and searching takes O(N)
 */
@SuppressWarnings("Duplicates")
public class BST<E extends Comparable<E>> {

    private TreeNode<E> root;
    private List<E> list = new LinkedList<>();

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

    public boolean find(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        return findHelper(root, elem);
    }

    private boolean findHelper(TreeNode<E> n, E elem) {
        if (n == null) return false;
        if (n.elem.compareTo(elem) == 0) return true;
        if (n.elem.compareTo(elem) > 0) return findHelper(n.left, elem);
        return findHelper(n.right, elem);
    }

    public void delete(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        deleteHelper(root, elem);
    }

    private TreeNode<E> deleteHelper(TreeNode<E> node, E elem) {
        if (node.elem.compareTo(elem) > 0) node.left = deleteHelper(node.left, elem);
        else if (node.elem.compareTo(elem) < 0) node.right = deleteHelper(node.right, elem);
        else {                                             // found, now let's remove it
            if (node.left == null && node.right == null) {
                node = null;                               // case 1: if the node has no child
            } else if (node.left == null || node.right == null) {
                if (node.left != null) node = node.left;   // case 2: if the node has only one child
                else node = node.right;
            } else {                                       // case 3: if the node has two child
                TreeNode<E> p = findMin(node.left);
                root.elem = p.elem;
                node.left = deleteHelper(node.left, p.elem);
            }
        }
        return node;
    }

    private TreeNode<E> findMin(TreeNode<E> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode<E> minRight(TreeNode<E> p, TreeNode<E> n) {
        if (n.right == null) return p;
        p = n;
        return minRight(p, n.right);
    }

    public void print() {
        traverse(root);
    }

    private void traverse(TreeNode<E> n) {
        if (n == null) return;
        System.out.print(n.elem + " ");
        if (n.left != null) traverse(n.left);
        if (n.right != null) traverse(n.right);
    }

    public List<E> asList() {
        makeList(root);
        return list;
    }

    public E getMax() {
        if (root == null) throw new NullPointerException();
        return getMaxHelper(root).elem;
    }

    private TreeNode<E> getMaxHelper(TreeNode<E> node) {
        if (node.right != null) node = getMaxHelper(node.right);
        return node;
    }

    public E getMin() {
        if (root == null) throw new NullPointerException();
        return getMinHelper(root).elem;
    }

    private TreeNode<E> getMinHelper(TreeNode<E> node) {
        if (node.left != null) node = getMinHelper(node.left);
        return node;
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
