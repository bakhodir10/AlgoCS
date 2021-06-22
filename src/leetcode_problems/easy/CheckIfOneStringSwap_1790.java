package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwap_1790 {

    // Time complexity: O(n). Space complexity: O(1)
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (list.size() > 4) return false;

            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(s1.charAt(i));
                list.add(s2.charAt(i));
            }
        }

        if (list.size() == 0) return true;

        return list.size() == 4 && list.get(0) == list.get(3) && list.get(1) == list.get(2);
    }
}
