package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Approach 2. Trie DS
public class SearchSuggestionsSystem2_1268 {

    private class Node {
        private boolean isWord;
        private final Node[] children;

        public Node() {
            this.children = new Node[26];
        }
    }

    private final Node root = new Node();
    private List<String> suggestedWords = new ArrayList<>();

    private void insert(String word) {
        Node curr = this.root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    private void search(String word) {
        Node curr = this.root;
        suggestedWords = new ArrayList<>();

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return;
            curr = curr.children[c - 'a'];
        }
        collectWordsDFS(curr, word);
    }

    private void collectWordsDFS(Node curr, String word) {
        if (suggestedWords.size() == 3) return;
        if (curr.isWord) suggestedWords.add(word);

        for (int i = 'a'; i <= 'z'; i++) {
            if (curr.children[i - 'a'] != null) collectWordsDFS(curr.children[i - 'a'], word + (char) i);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new LinkedList<>();

        for (String product : products) insert(product);

        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            search(sb.append(c).toString());
            result.add(suggestedWords);
        }
        return result;
    }
}