package leetcode_problems.hard;

// Approach. Using Trie DS
public class PrefixAndSuffixSearch_745 {

    private class Node {
        private boolean isWord;
        private final Node[] children;

        public Node() {
            this.isWord = false;
            this.children = new Node[26];
        }
    }

    private final Node prefixRoot;
    private final Node suffixRoot;

    public PrefixAndSuffixSearch_745(String[] words) {
        this.prefixRoot = new Node();
        this.suffixRoot = new Node();

        for (String word : words) {
            insert(this.prefixRoot, word);
            insert(this.suffixRoot, new StringBuilder(word).reverse().toString());
        }
    }

    private void insert(Node root, String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    private boolean search(Node root, String word) {
        Node curr = root;
        int idx = 0;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public int f(String prefix, String suffix) {

        System.out.println("prefix: " + search(this.prefixRoot, prefix));
        System.out.println("suffix: " + search(this.suffixRoot, suffix));

        return -2;
    }
}
