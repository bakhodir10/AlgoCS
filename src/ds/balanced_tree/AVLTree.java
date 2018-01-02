package ds.balanced_tree;

public class AVLTree<E extends Comparable<E>> {
    private AVLNode<E> root;

    private int height(AVLNode<E> n) {
        return n == null ? -1 : n.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int getBalance(AVLNode<E> n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    private AVLNode<E> leftRotate(AVLNode<E> x) {
        AVLNode<E> y = x.right;
        AVLNode<E> z = y.left;

        // rotation
        y.left = x;
        x.right = z;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return y;
    }

    private AVLNode<E> rightRotate(AVLNode<E> y) {
        AVLNode<E> x = y.left;
        AVLNode<E> z = x.right;

        //rotation
        x.right = y;
        y.left = z;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return x;
    }

    public void insert(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        root = insertHelper(root, elem);
    }

    private AVLNode<E> insertHelper(AVLNode<E> n, E elem) {
        // usual insert
        if (n == null) return new AVLNode<>(elem);
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

    private class AVLNode<E> {
        private int height;
        private E elem;
        private AVLNode<E> left, right;

        public AVLNode(E elem) {
            this.elem = elem;
        }
    }
}
