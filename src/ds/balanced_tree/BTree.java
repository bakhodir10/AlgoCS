package ds.balanced_tree;

/*
Properties of B-Tree
1) All leaves are at same level.
2) A B-Tree is defined by the term minimum degree ‘t’. The value of t depends upon disk block size.
3) Every node except root must contain at least t-1 keys. Root may contain minimum 1 key.
4) All nodes (including root) may contain at most 2t – 1 keys.
5) Number of children of a node is equal to the number of keys in it plus 1.
6) All keys of a node are sorted in increasing order. The child between two keys k1 and k2 contains all keys in range from k1 and k2.
7) B-Tree grows and shrinks from root which is unlike Binary Search Tree. Binary Search Trees grow downward and also shrink from downward.
8) Like other balanced Binary Search Trees, time complexity to search, insert and delete is O(Logn).
 */
// todo implementations
public class BTree<E> {

    private class BTreeNode<E> {
        private int order; // The number of values that a B-tree node can hold
        private Node[] nodes;

        public BTreeNode(int order) {
            this.order = order;
            nodes = new Node[order];
        }
    }

    private class Node<E> {
        private E elem;

        public Node(E elem) {
            this.elem = elem;
        }
    }
}
