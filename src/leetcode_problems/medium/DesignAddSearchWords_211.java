package leetcode_problems.medium;

public class DesignAddSearchWords_211 {

    private class Node {
        private boolean isWord;
        private final Node[] children;

        public Node() {
            this.children = new Node[255];
        }
    }

    private final Node root;

    public DesignAddSearchWords_211() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.children[c] == null) curr.children[c] = new Node();
            curr = curr.children[c];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return helper(word.toCharArray(), 0, root);
    }

    private boolean helper(char[] chars, int idx, Node curr) {

        for (int i = idx; i < chars.length; i++) {
            char c = chars[i];
            if (curr.children[c] == null) {
                if (c == '.') {
                    for (Node child : curr.children) {
                        if (child != null && helper(chars, i + 1, child)) return true;
                    }
                }
                return false;
            } else {
                curr = curr.children[c];
            }
        }
        return curr.isWord;
    }
}
