package leetcode_problems.medium;

public class LongestWordWithAllPrefixes_1858 {

    private static class Node {
        private boolean isWord;
        private final Node[] children;

        public Node() {
            this.children = new Node[26];
        }
    }

    private final Node root = new Node();

    private void insert(String s) {
        Node curr = this.root;

        for (char c : s.toCharArray()) {
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    private boolean hasAllPrefixes(String s) {
        Node curr = this.root;

        for (char c : s.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            if (!curr.children[c - 'a'].isWord) return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public String longestWord(String[] words) {
        for (String word : words) insert(word);

        String smallest = "";

        for (String word : words) {

            if (hasAllPrefixes(word)) {
                if (smallest.isEmpty()) {
                    smallest = word;
                } else {
                    if (smallest.length() < word.length()) smallest = word;
                    else if (smallest.length() == word.length()) {
                        if (smallest.compareTo(word) >= 1) smallest = word;
                    }
                }
            }
        }
        return smallest;
    }
}
