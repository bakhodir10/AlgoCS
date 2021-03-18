package problems.medium;

import java.util.Collections;
import java.util.List;

public class LongestWordDictionary_524 {

    // Time complexity: O(nlogn + max(dictionary) * s). Space complexity: O(n)
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);

        int count = 0;
        String longestWord = "";

        for (String word : dictionary) {
            if (matches(s.toCharArray(), word.toCharArray()) && count < word.length()) {
                count = word.length();
                longestWord = word;
            }
        }
        return longestWord;
    }

    private boolean matches(char[] s, char[] sInDict) {
        int i = 0, j = 0;

        while (i < s.length && j < sInDict.length) {
            if (s[i] == sInDict[j]) j++;
            i++;
        }
        return j == sInDict.length;
    }
}
