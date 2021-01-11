package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters_1002 {

    // Time complexity: O(n). Space complexity: O(1)
    public List<String> commonChars(String[] strArr) {
        if (strArr == null || strArr.length == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        int[] commonCharsCount = calcCountOfChars(strArr[0]);

        for (String s : strArr) {
            int[] countOfChars = calcCountOfChars(s);
            for (int i = 0; i < 26; i++) {
                commonCharsCount[i] = Math.min(commonCharsCount[i], countOfChars[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < commonCharsCount[i]; j++) result.add(Character.toString((char) (i + 'a')));
        }
        return result;
    }

    private int[] calcCountOfChars(String s) {
        int[] countOfChars = new int[26];
        for (char c : s.toCharArray()) countOfChars[c - 'a']++;
        return countOfChars;
    }
}