package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfMaxBitwiseOR_2044 {

    // Time complexity: O(2 ^ n)
    // Space complexity: O(n)
    Map<Integer, Integer> counts = new HashMap<>();
    public int countMaxOrSubsets(int[] nums) {
        backtrack(0, nums, 0);
        int maxIdx = 0;
        for(int maxOrVal: counts.keySet()) maxIdx = Math.max(maxIdx, maxOrVal);
        return counts.get(maxIdx);
    }

    private void backtrack(int idx, int[] nums, int orBitwiseSoFar) {
        counts.put(orBitwiseSoFar, counts.getOrDefault(orBitwiseSoFar, 0) + 1);
        for(int i = idx; i < nums.length; i ++) {
            backtrack(i + 1, nums, orBitwiseSoFar | nums[i]);
        }
    }
}
