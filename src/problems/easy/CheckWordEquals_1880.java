package problems.easy;

import java.util.Arrays;

public class CheckWordEquals_1880 {

    // Time complexity: O(n). Space complexity: O(1)
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNumValue(firstWord) + getNumValue(secondWord) == getNumValue(targetWord);
    }

    private int getNumValue(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) sum = sum * 10 + c - 'a';
        return sum;
    }
}
