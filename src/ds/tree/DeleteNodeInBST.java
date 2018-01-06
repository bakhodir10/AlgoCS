package ds.tree;

@SuppressWarnings("Duplicates")
public class DeleteNodeInBST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void delete(E elem) {
        root = deleteHelper(root, elem);
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
