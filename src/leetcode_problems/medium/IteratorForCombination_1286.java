package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorForCombination_1286 {

    List<String> combinations = new ArrayList<>();
    Iterator<String> combIterator;

    // Time complexity: O(n * 2^n)
    // Space complexity: (n)
    public IteratorForCombination_1286(String characters, int combinationLength) {
        backtrack(characters.toCharArray(), 0, combinationLength, new StringBuilder());
        combIterator = combinations.iterator();
    }

    private void backtrack(char[] c, int idx, int k, StringBuilder sb) {
        if(sb.length() >= k) {
            combinations.add(sb.toString());
            return;
        }

        for(int i = idx; i < c.length; i ++) {
            sb.append(c[i]);
            backtrack(c, i + 1, k, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Time complexity: O(1)
    // Space complexity: (1)
    public String next() {
        return combIterator.next();
    }

    // Time complexity: O(1)
    // Space complexity: (1)
    public boolean hasNext() {
        return combIterator.hasNext();
    }
}
