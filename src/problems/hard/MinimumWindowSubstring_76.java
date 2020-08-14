package problems.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> charsWithCount = new HashMap<>();
        int minLen = 0, slow = 0, start = 0, end = 0;

        for (char c : t.toCharArray()) charsWithCount.put(c, charsWithCount.getOrDefault(c, 0) + 1);
        int currentDiffCharsCount = charsWithCount.size();

        for (int fast = 0; fast < s.length(); fast ++) {
            if (!charsWithCount.containsKey(s.charAt(fast))) continue;

            int charCountFast = charsWithCount.get(s.charAt(fast));
            charsWithCount.put(s.charAt(fast), --charCountFast);
            if (charCountFast == 0) currentDiffCharsCount--;

            while (currentDiffCharsCount == 0) {

                if (minLen == 0) {
                    minLen = fast - slow + 1;
                    start = slow;
                    end = fast + 1;
                } else if (minLen > fast - slow + 1) {
                    minLen = fast - slow + 1;
                    start = slow;
                    end = fast + 1;
                }

                if (charsWithCount.containsKey(s.charAt(slow))) {
                    int charCountSlow = charsWithCount.get(s.charAt(slow));
                    if (charCountSlow == 0) currentDiffCharsCount++;
                    charsWithCount.put(s.charAt(slow), ++charCountSlow);
                }
                slow++;
            }
        }
        return s.substring(start, end);
    }
}
