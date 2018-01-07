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
        if (balance > 1 && n.left.elem.compareTo(elem) > 0) return rightRotate(n);
            // right-right case
        else if (balance < -1 && n.right.elem.compareTo(elem) < 0) return leftRotate(n);
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
        if (elem == null) throw new IllegalArgumentException();
        root = deleteHelper(root, elem);
    }

    private AVLNode<E> deleteHelper(AVLNode<E> node, E elem) {
        if (node.elem.compareTo(elem) > 0) node.left = deleteHelper(node.left, elem);
        else if (node.elem.compareTo(elem) < 0) node.right = deleteHelper(node.right, elem);
        else {                                             // found, now let's remove it
            if (node.left == null && node.right == null) {
                node = null;                               // case 1: if the node has no child
            } else if (node.left == null || node.right == null) {
                if (node.left != null) node = node.left;   // case 2: if the node has only one child
                else node = node.right;
            } else {                                       // case 3: if the node has two child
                AVLNode<E> p = findMin(node.left);
                node.elem = p.elem;
                node.left = deleteHelper(node.left, p.elem);
            }
        }

        if (node == null) return null;
        node.height = max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return node;
    }

    private AVLNode<E> findMin(AVLNode<E> node) {
        while (node.right != null) {
            node = node.right;
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
