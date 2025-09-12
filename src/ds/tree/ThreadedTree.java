package ds.tree;

/*
A java.stream_java8.thread is a series of links that allow you to move through the nodes in a tree or
network in a way others than by following normal branches or links. A threaded
tree is a tree that contains one or more threads.
 */

public class ThreadedTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E elem) {
        TreeNode<E> newNode = new TreeNode<>(elem);
        if (root == null) root = newNode;
        else insertHelper(root, newNode);
    }

    private void insertHelper(TreeNode<E> n, TreeNode<E> newNode) {
        if (n.elem.compareTo(newNode.elem) > 0) {
            if (n.leftChild != null) insertHelper(n.leftChild, newNode);
            else {
                newNode.leftThread = n.leftThread;
                newNode.rightThread = n;
                n.leftThread = null;
                n.leftChild = newNode;
            }
        } else {
            if (n.rightChild != null) insertHelper(n.rightChild, newNode);
            else {
                newNode.leftThread = n;
                newNode.rightThread = n.rightThread;
                n.rightThread = null;
                n.rightChild = newNode;
            }
        }
    }

    public void print() {
        inOrderTraversal(root);
        reverseInOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode<E> root) {
        TreeNode<E> n = root;
        boolean viaChild = true;
        while (n != null) {
            if (viaChild)
                while (n.leftChild != null) n = n.leftChild;
            System.out.print(n.elem + " ");
            if (n.rightChild == null) {
                n = n.rightThread;
                viaChild = false;
            } else {
                n = n.rightChild;
                viaChild = true;
            }
        }
    }

    private void reverseInOrderTraversal(TreeNode<E> root) {
        TreeNode<E> n = root;
        boolean b = true;
        while (n != null) {
            if (b) {
                while (n.rightChild != null) {
                    n = n.rightChild;
                }
            }
            System.out.print(n.elem + " ");
            if (n.leftChild != null) {
                n = n.leftChild;
                b = true;
            } else {
                n = n.leftThread;
                b = false;
            }
        }
    }

    private class TreeNode<E> {
        private E elem;
        private TreeNode<E> leftThread, rightThread;
        private TreeNode<E> leftChild, rightChild;

        public TreeNode(E elem) {
            this.elem = elem;
        }

        public TreeNode(E elem, TreeNode<E> leftChild, TreeNode<E> rightChild) {
            this.elem = elem;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
