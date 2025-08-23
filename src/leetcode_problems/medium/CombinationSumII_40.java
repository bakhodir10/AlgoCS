package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII_40 {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> subResult = new LinkedList<>();

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    public List<List<Integer>> combinationSum2(int[] c, int target) {
        Arrays.sort(c);
        backtrack(0, c, target, 0);
        return result;
    }

    private void backtrack(int idx, int[] c, int target, int sumSoFar) {
        if(sumSoFar > target) return;

        if(sumSoFar == target) {
            result.add(new LinkedList<>(subResult));
            return;
        }

        for(int i = idx; i < c.length; i ++) {
            if(i != idx && c[i - 1] == c[i]) continue;
            sumSoFar += c[i];
            subResult.add(c[i]);

            backtrack(i + 1, c, target, sumSoFar);

            sumSoFar -= c[i];
            subResult.removeLast();
        }
    }

}
