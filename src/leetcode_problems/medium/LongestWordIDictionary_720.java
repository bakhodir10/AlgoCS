package leetcode_problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordIDictionary_720 {

    // Time complexity: O(n(words length) * m(longest word size in words)). Space complexity(n(words length));
    public String longestWord(String[] words) {
        String res = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));

        out:
        for (String word : words) {
            StringBuilder sb = new StringBuilder();

            for (char c : word.toCharArray()) {
                sb.append(c);
                if (!set.contains(sb.toString())) continue out;
            }
            if (res.isEmpty()) res = word;
            else {
                if (res.length() < word.length()) res = word;
                else if (res.length() == word.length() && res.compareTo(word) >= 1) res = word;
            }
        }
        return res;
    }
}
