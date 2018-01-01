package ds.balanced_tree;

public class AVLTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        root = insertHelper(root, elem);
    }

    private TreeNode<E> insertHelper(TreeNode<E> n, E elem) {
        // usual insert
        if (n == null) return new TreeNode<>(elem);
        if (n.elem.compareTo(elem) > 0) n.left = insertHelper(n.left, elem);
        else if (n.elem.compareTo(elem) < 0) n.right = insertHelper(n.right, elem);

        // increase height of the node
        n.height = 1 + max(height(n.left), height(n.right));

        // get the balance of current node
        int balance = getBalance(n);

        // if it is not balanced, there are 4 types.

        // left-left case
        if (balance > 1 && n.elem.compareTo(elem) > 0) return rightRotate(n);
            // right-right case
        else if (balance < -1 && n.elem.compareTo(elem) < 0) return leftRotate(n);
            //left-right case
        else if (balance > 1 && n.left.elem.compareTo(elem) < 0) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }
        //right-left case
        else if (balance < -1 && n.right.elem.compareTo(elem) > 0) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }
        return n;
    }
    
    public void traverse() {
        helper(root);
    }

    private void helper(TreeNode<E> root) {
        if (root == null) return;
        System.out.println(root.elem);
        if (root.left != null) helper(root.left);
        if (root.right != null) helper(root.right);
    }

    private TreeNode<E> rightRotate(TreeNode<E> y) {
        TreeNode<E> x = y.left;
        TreeNode<E> z = x.right;

        //rotation
        x.right = y;
        y.left = z;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return x;
    }

    private TreeNode<E> leftRotate(TreeNode<E> x) {
        TreeNode<E> y = x.right;
        TreeNode<E> z = y.left;

        // rotation
        y.left = x;
        x.right = z;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return y;
    }

    private int height(TreeNode<E> n) {
        return n == null ? -1 : n.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int getBalance(TreeNode<E> n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }


    private class TreeNode<E> {
        private int height;
        private E elem;
        private TreeNode<E> left, right;

        public TreeNode(E elem) {
            this.elem = elem;
        }
    }
}
