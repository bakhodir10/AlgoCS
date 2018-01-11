package ds.balanced_tree;

/*
Red-Black Tree is a self-balancing Binary Search Tree (BST) where every node follows following rules.

1) Every node has a color either red or black.
2) Root of tree is always black.
3) There are no two adjacent red nodes (A red node cannot have a red parent or red child).
4) Every path from root to a NULL node has same number of black nodes.

 */
public class RedBlackTree<E extends Comparable<E>> {
    private RBNode<E> root;

    public void insert(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        if (root == null) root = new RBNode<>(elem, null, Color.BLACK); // if it is root node
        else root = insertHelper(root, root, elem);                            // if it is not root node
    }

    private RBNode<E> insertHelper(RBNode<E> node, RBNode<E> parent, E elem) {
        // usual insert
        if (node == null) return new RBNode<>(elem, parent, Color.RED);
        if (node.elem.compareTo(elem) > 0) node.left = insertHelper(node.left, node, elem);
        else if (node.elem.compareTo(elem) < 0) node.right = insertHelper(node.right, node, elem);

        if (node.color == Color.BLACK) return node; // the parent of current node is black
        else {                                      // the parent of current node is red
            if (node.parent.left != null && node.parent.left.color == Color.RED &&
                    node.parent.right != null && node.parent.right.color == Color.RED) {  // uncle node is red
                if (node.parent.parent == null) node = recoloring(node, true); // parent is root node
                else {
                    node = recoloring(node, false);         //parent is not root node
                }
            } else {                                                // uncle node is black, not red, then we have to rotate it
                // like a AVL tree we have 4 rotating case
                // case 1: right-right
                if (node.right != null && node.right.elem.compareTo(elem) == 0 &&
                        node.parent != null && node.parent.right.elem.compareTo(node.elem) == 0) {
                    return leftRotate(node, node.parent, true);
                }
                // case 2: right-left
                if (node.left != null && node.left.elem.compareTo(elem) == 0 &&
                        node.parent != null && node.parent.right.elem.compareTo(node.elem) == 0) {
                    node.right = rightRotate(node, node.parent, false);
                    return leftRotate(node, node.parent, true);
                }
                // case 3: left-left
                if (node.left != null && node.left.elem.compareTo(elem) == 0 &&
                        node.parent != null && node.parent.left.elem.compareTo(node.elem) == 0) {
                    return rightRotate(node, node.parent, true);
                }
                // case 4: left-right
                if (node.right != null && node.right.elem.compareTo(elem) == 0 &&
                        node.parent != null && node.parent.left.elem.compareTo(node.elem) == 0) {
                    node.left = leftRotate(node, node.parent, false);
                    return rightRotate(node, node.parent, true);
                }
            }
        }
        return node;
    }

    private RBNode<E> recoloring(RBNode<E> n, boolean isRoot) {
        n.parent.left.color = Color.BLACK;
        n.parent.right.color = Color.BLACK;
        if (!isRoot) {
            n.parent.color = Color.RED;
            return n.parent;
        } else return n;
    }

    private RBNode<E> leftRotate(RBNode<E> n, RBNode<E> pt, boolean changeColor) {
        RBNode<E> pt_right = pt.right;
        pt.right = pt_right.left;
        if (pt.right != null) pt.right.parent = pt;
        pt_right.parent = pt.parent;
        if (pt.parent == null) root = pt_right;
        else if (pt == pt.parent.left) pt.parent.left = pt_right;
        else pt.parent.right = pt_right;
        pt_right.left = pt;
        pt.parent = pt_right;

        // coloring
        if (changeColor) {
            pt.color = Color.RED;
            n.color = Color.BLACK;
        }
        return n;
    }

    private RBNode<E> rightRotate(RBNode<E> n, RBNode<E> pt, boolean changeColor) {
        RBNode<E> pt_left = pt.left;
        pt.left = pt_left.right;
        if (pt.left != null) pt.left.parent = pt;
        pt_left.parent = pt.parent;
        if (pt.parent == null) root = pt_left;
        else if (pt == pt.parent.left) pt.parent.left = pt_left;
        else pt.parent.right = pt_left;
        pt_left.right = pt;
        pt.parent = pt_left;

        // coloring
        if (changeColor) {
            pt.color = Color.RED;
            n.color = Color.BLACK;
        }

        return n;
    }

    public boolean find(E elem) {
        return findHelper(root, elem);
    }

    private boolean findHelper(RBNode<E> node, E elem) {
        if (node == null) return false;
        if (node.elem.compareTo(elem) == 0) return true;
        if (node.elem.compareTo(elem) > 0) return findHelper(node.left, elem);
        else return findHelper(node.right, elem);
    }

    private class RBNode<E> {
        private E elem;
        private Color color;
        private RBNode<E> left, right, parent;

        public RBNode(E elem, RBNode<E> parent, Color color) {
            this.elem = elem;
            this.parent = parent;
            this.color = color;
        }
    }

    private enum Color {
        RED, BLACK
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> rb = new RedBlackTree<>();
        rb.insert(6);
        rb.insert(-3);
        rb.insert(10);
        rb.insert(15);
        rb.insert(20);
    }
}
