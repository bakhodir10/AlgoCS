package ds.balanced_tree;

/*
 An AVL tree is a sorted binary tree in which the heights of two subtrees at any
 given node differ by at most 1
 Space:
  Best case: O(N)
  Worst case: O(N)
 Time complexity:
  Building binary tree:
   Best case: O(logN)
   Worst case: O(logN)

   Best case:
    Searching element: O(logN)
    Adding element: O(logN)   -> to add, find new element position where belongs to
    Delete element: O(logN)   -> to add, find new element position where belongs to
   Worst case:
    Searching element: O(logN) -> every element sorted order
    Adding element: O(logN)
    Delete element: O(logN)
 */
@SuppressWarnings("Duplicates")
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

    public void delete(E elem) {
        if (elem == null || root == null) throw new IllegalArgumentException();
        root = deleteHelper(root, elem);
    }

    private AVLNode<E> deleteHelper(AVLNode<E> node, E elem) {
        // usual delete node from tree
        if (node.elem.compareTo(elem) > 0) node.left = deleteHelper(node.left, elem);
        if (node.elem.compareTo(elem) < 0) node.right = deleteHelper(node.right, elem);
        else {
            if (node.left == null && node.right == null) {        // case 1: the node has no child
                node = null;
            } else if (node.left == null || node.right == null) { // case 2: the node has a child
                if (node.left != null) node = node.left;
                else node = node.right;
            } else {                                              // case 3: the node has two child
                AVLNode<E> p = node.left;
                if (p.right != null) {
                    while (p.right.right != null) p = p.right;
                    node.elem = p.right.elem;
                    p.right = null;
                } else {
                    p.right = node.right;
                    node = p;
                }
                node.height = max(height(node.left), height(node.right)) + 1;
                int balance = getBalance(node);

                // if the node is not balanced
                // left-left case
                if (balance > -1 && getBalance(node.left) >= 0) {
                    return rightRotate(node);
                }
                // left-right case
                if (balance > -1 && getBalance(node.left) < 0) {
                    node.left = leftRotate(node);
                    return rightRotate(node);
                }
                // right-right case
                if (balance < -1 && getBalance(node.right) <= 0) {
                    return leftRotate(node);
                }
                // right-left case
                if (balance < -1 && getBalance(node.right) > -1) {
                    node.right = rightRotate(node);
                    return leftRotate(node);
                }
            }
        }
        return node;
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
