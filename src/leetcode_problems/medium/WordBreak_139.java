package leetcode_problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
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