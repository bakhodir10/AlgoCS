package ds.tree;

public class DeleteNodeInBST<E extends Comparable<E>> {
    private TreeNode<E> root;

    //first approach
    private TreeNode<E> deleteHelper1(TreeNode<E> node, E elem) {
        if (node == null) return null;
        else switch (elem.compareTo(node.elem)) {
            case 1:
                node.right = deleteHelper1(node.right, elem);
                break;
            case -1:
                node.left = deleteHelper1(node.left, elem);
                break;
            default:
                if (node.left == null) node = node.right;
                else if (node.right == null) node = node.left;
                else {
                    TreeNode<E> p = node.left;
                    if (p.right != null) {
                        while (p.right.right != null) p = p.right;
                        node.elem = p.right.elem;
                        p.right = null;
                    } else {
                        p.right = node.right;
                        node = p;
                    }
                }
        }
        return node;
    }

    public void delete1(E elem) {
        root = deleteHelper1(root, elem);
    }

    // ***************************************************************************

    //the second approach

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
