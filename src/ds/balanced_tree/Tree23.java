package ds.balanced_tree;

/*
In a 2-3 tree, every internal node has either two or three children. A node that
has two children is called a 2-node, and a node that has three children is called a
3-node. Because every internal node has at least two children, a tree containing
N nodes can have a height of at most log 2 (N).
 */

// todo insert and delete methods implementations
public class Tree23<E extends Comparable<E>> {
    private Tree23Node<E> root;

    public void insert(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        root = insertHelper(root, elem);
    }

    private Tree23Node<E> insertHelper(Tree23Node<E> node, E elem) {
        if (node == null) return new Tree23Node<>(elem);
        return null;
    }

    /*
Nodes can have a height of at most log 2 (N). Nodes with two children work the way the nodes do
in a normal binary tree.Such a node holds a value. When you’re searching the tree, you look down the node’s
left or right branch, depending on whether the target value is less than or greater than the node’s value.
Nodes with three children hold two values. When you’re searching the tree, you look down this node’s left,
middle, or right branch, depending on whether the target value is less than the node’s fi rst value,
between its first and second value, or greater than its second value.
     */
    public boolean find(E elem) {
        if (elem == null) throw new IllegalArgumentException();
        return findHelper(root, elem);
    }

    private boolean findHelper(Tree23Node<E> node, E elem) {
        if (node == null) return false;
        if (node.leftElem != null && node.leftElem.compareTo(elem) == 0) return true;
        if (node.rightElem != null && node.rightElem.compareTo(elem) == 0) return true;

        if (node.rightElem != null && node.leftElem.compareTo(elem) < 0 && node.rightElem.compareTo(elem) > 0)
            return findHelper(node.middleNode, elem);
        else if (node.rightElem != null && node.rightElem.compareTo(elem) < 0)
            return findHelper(node.rightNode, elem);
        else return findHelper(node.leftNode, elem);
    }

    /*
    A node that can hold up to two values and three children.
    Then add a property that tells how many values are in use
     */
    private class Tree23Node<E> {
        int inUse;
        private E leftElem, rightElem;
        private Tree23Node<E> rightNode, middleNode, leftNode;

        public Tree23Node(E leftElem) {
            this.leftElem = leftElem;
        }

        public Tree23Node(E leftElem, E rightElem) {
            this.leftElem = leftElem;
            this.rightElem = rightElem;
        }
    }
}
