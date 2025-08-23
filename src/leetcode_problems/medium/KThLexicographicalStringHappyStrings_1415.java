package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KThLexicographicalStringHappyStrings_1415 {

    // Time complexity: O(n*2^n)
    // Space complexity: O(n)
    String found = "";
    int kth = 0;
    public String getHappyString(int n, int k) {
        kth = k;
        StringBuilder sb = new StringBuilder();
        backtrack(new char[]{'a', 'b', 'c'}, sb, n, ' ');
        return found;
    }

    private void backtrack(char[] c, StringBuilder curr, int n, char lastC) {
        if(kth <= 0) return;

        if(curr.length() == n) {
            kth--;
            if(kth == 0) found = curr.toString();
            return;
        }

        for (char value : c) {
            if (lastC == value) continue;

            curr.append(value);
            backtrack(c, curr, n, value);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
