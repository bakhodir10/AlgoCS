package leetcode_problems.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII_212 {

    public static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }

        public void addWord(String s) {
            TrieNode curr = this;
            for(char c: s.toCharArray()) {
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }
    }

    Set<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        result = new HashSet<>();
        boolean[][] visit = new boolean[board.length][board[0].length];

        for(String s: words) root.addWord(s);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                helper(board, i, j, "", visit, root);
            }
        }
        return new ArrayList<>(result);
    }

    private void helper(char[][] board, int i, int j, String s, boolean[][] visit, TrieNode curr) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visit[i][j] || curr.children[board[i][j] - 'a'] == null) {
            return;
        }

        visit[i][j] = true;
        s += board[i][j];
        curr = curr.children[board[i][j] - 'a'];

        if(curr.isWord) result.add(s);

        helper(board, i + 1, j, s, visit, curr);
        helper(board, i - 1, j, s, visit, curr);
        helper(board, i, j + 1, s, visit, curr);
        helper(board, i, j - 1, s, visit, curr);

        visit[i][j] = false;
    }
}