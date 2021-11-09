package leetcode_problems.medium;

import java.util.List;

public class ReplaceWords_648 {

    // Approach 1. Using HashMap
    public String replaceWords1(List<String> dict, String sentence) {
        StringBuilder out = new StringBuilder();
        String[] sentenceWords = sentence.split(" ");

        for (String sentenceWord : sentenceWords) {
            int minLen = Integer.MAX_VALUE;
            String minLenWord = sentenceWord;

            for (String dictWord : dict) {
                if (sentenceWord.startsWith(dictWord) && dictWord.length() < minLen) {
                    minLen = dictWord.length();
                    minLenWord = dictWord;
                }
            }
            out.append(minLenWord).append(" ");
        }

        return out.toString().trim();
    }

    // Approach 2. Using Trie
    private final Node root = new Node();

    public String replaceWords2(List<String> dict, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String root : dict) this.insert(root);

        for (String successor : words) {
            String root = findRoot(successor);

            if (!root.isEmpty()) sb.append(root).append(" ");
            else sb.append(successor).append(" ");
        }
        return sb.toString().trim();
    }

    static class Node {
        private boolean isWord;
        private final Node[] children;

        public Node() {
            this.children = new Node[26];
        }
    }

    private void insert(String word) {
        Node curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            if (i == word.length() - 1) curr.children[c - 'a'].isWord = true;
            curr = curr.children[c - 'a'];
        }
    }

    private String findRoot(String word) {
        Node curr = this.root;
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            sb.append(c);
            if (curr.children[c - 'a'] == null) return "";
            if (curr.children[c - 'a'].isWord) return sb.toString();
            curr = curr.children[c - 'a'];
        }
        return sb.toString();
    }
}