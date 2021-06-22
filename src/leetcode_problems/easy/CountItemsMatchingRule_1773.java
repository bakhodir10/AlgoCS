package leetcode_problems.easy;

import java.util.List;

public class CountItemsMatchingRule_1773 {

    // Time complexity: O(n). Space complexity: O(1)
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0, index = -1;

        if (ruleKey.equals("type")) index = 0;
        else if (ruleKey.equals("color")) index = 1;
        else index = 2;

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) count++;
        }
        return count;
    }
}
