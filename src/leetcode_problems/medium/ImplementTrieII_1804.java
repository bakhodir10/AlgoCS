package leetcode_problems.medium;

public class ImplementTrieII_1804 {

    private class Node {
        private final Node[] children;
        private int countOfWords;
        private int countOfStartWith;

        public Node() {
            this.countOfWords = 0;
            this.countOfStartWith = 0;
            this.children = new Node[26];
        }
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            curr.children[c - 'a'].countOfStartWith++;
            curr = curr.children[c - 'a'];
        }
        curr.countOfWords++;
    }

    public int countWordsEqualTo(String word) {
        Node curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return 0;
            curr = curr.children[c - 'a'];
        }
        return curr.countOfWords;
    }

    public int countWordsStartingWith(String prefix) {
        Node curr = this.root;

        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) return 0;
            curr = curr.children[c - 'a'];
        }
        return curr.countOfStartWith;
    }

    public void erase(String word) {
        Node curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return;
            curr.children[c - 'a'].countOfStartWith--;
            curr = curr.children[c - 'a'];
        }
        curr.countOfWords--;
    }
}
