package leetcode_problems.medium;

import java.util.*;

public class WordBreak_139 {

    // n -> string size, k -> number of words in dictionary, L -> average word length
    // Time complexity: O(n*k*L)
    // Space complexity: O(n)
    String word;
    List<String> words;
    Map<Integer, Boolean> memo;
    public boolean wordBreak2(String s, List<String> wordDict) {
        this.word = s;
        this.words = wordDict;
        this.memo = new HashMap<>();
        return backtrack(0);
    }

    private boolean backtrack(int start) {
        if (start > word.length()) return false;
        if (memo.containsKey(start)) return memo.get(start);
        if (start == word.length()) return true;

        for (String w : words) {
            if (start + w.length() <= word.length() && word.startsWith(w, start)) {
                if (backtrack( start + w.length())) {
                    memo.put(start + w.length(), true);
                    return true;
                }
            }
        }
        memo.put(start, false);
        return false;
    }

    // Time complexity: O(n^3)
    // Space complexity: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length()];
        Arrays.fill(memo, true);
        return helper(s, new HashSet<>(wordDict), memo, 0);
    }

    private boolean helper(String s, Set<String> set, boolean[] memo, int index) {
        if (s.isEmpty()) return true;
        if (!memo[index]) return false;

        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i)) && helper(s.substring(i), set, memo, index + i)) {
                return true;
            }
        }
        memo[index] = false;
        return false;
    }
}