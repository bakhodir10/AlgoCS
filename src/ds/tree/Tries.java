package ds.tree;

/*
Tries:
Example
        W
       / \
     ISP  A
           \
            N
           / \
          T   E

  Input: WANE
  Output: true

  Input: WISP
  Output: true
 */
// todo not done
public class Tries {
    private TreeNode root;
    private String res;

    public void insert(String elem) {
        if (elem == null) return;
        if (root == null) root = new TreeNode(elem);
        else insertHelper(root, elem);
    }

    private void insertHelper(TreeNode n, String elem) {
        if (n == null) return;
        if (n.elem.compareTo(elem) > 0) {
            if (n.left != null) insertHelper(n.left, elem);
            else n.left = new TreeNode(elem);
        }
        if (n.elem.compareTo(elem) < 0) {
            if (n.right != null) insertHelper(n.right, elem);
            else n.right = new TreeNode(elem);
        }
    }


    public boolean find(String elem) {
        if (elem == null) return false;
        return findHelper(root, elem);
    }

    private boolean findHelper(TreeNode n, String elem) {
        if (n == null) return false;
        if (n.elem.equals(elem)) return true;
        if (n.elem.compareTo(elem) > 0) return findHelper(n.left, elem);
        return findHelper(n.right, elem);
    }

    private class TreeNode {
        private String elem;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String elem) {
            this.elem = elem;
        }
    }
}
