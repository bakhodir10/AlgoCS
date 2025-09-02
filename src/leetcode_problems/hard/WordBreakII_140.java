package leetcode_problems.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII_140 {

    List<String> result;
    Set<String> words;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.result = new ArrayList<>();
        this.words = new HashSet<>(wordDict);
        backtrack(s, 0, "");
        return result;
    }

    private void backtrack(String s, int start, String path) {
        if (start > s.length()) return;

        if (start == s.length()) {
            result.add(path.trim());
            return;
        }

        for (String word : words) {
            if (start + word.length() <= s.length() && s.startsWith(word, start)) {
                backtrack(s, start + word.length(), path + " " + word);
            }
        }
    }
}
