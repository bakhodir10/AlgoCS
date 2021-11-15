package leetcode_problems.medium;

public class DesignFileSystem_1166 {

    private class Node {
        private int val;
        private boolean isWord;
        private final Node[] children;

        public Node() {
            this.isWord = false;
            this.children = new Node[256];
        }
    }

    private final Node root;

    public DesignFileSystem_1166() {
        this.root = new Node();
    }

    public boolean createPath(String path, int val) {
        Node curr = this.root;

        if (search(path) != -1) return false; // return true if the path exists

        String parentPath = "/";
        String[] paths = path.split("/");

        // check for each parent path if it exists
        for (int i = 1; i < paths.length - 1; i++) {
            parentPath = parentPath + paths[i];
            if (search(parentPath) == -1) return false; // return false if parent path doesn't exist
            parentPath = parentPath + "/";
        }

        for (char c : path.toCharArray()) {
            if (curr.children[c] == null) curr.children[c] = new Node();
            curr = curr.children[c];
        }

        curr.isWord = true;
        curr.val = val;
        return true;
    }

    private int search(String word) {
        Node curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.children[c] == null) return -1;
            curr = curr.children[c];
        }

        if (!curr.isWord) return -1;
        return curr.val;
    }

    public int get(String path) {
        return search(path);
    }
}
