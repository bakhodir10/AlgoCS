package leetcode_problems.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeArray_697 {

    // Time complexity: O(n). Space complexity: O(n)
    public static int findShortestSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> maxIndexes = new HashMap<>();
        Map<Integer, Integer> minIndexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = counts.getOrDefault(nums[i], 0);
            counts.put(nums[i], ++count);
            if (!minIndexes.containsKey(nums[i])) minIndexes.put(nums[i], i);
            maxIndexes.put(nums[i], i);
        }

        int maxDegree = Integer.MIN_VALUE;
        int minSubArraySize = Integer.MAX_VALUE;

        for (int count : counts.values()) maxDegree = Math.max(maxDegree, count);

        for (Map.Entry<Integer, Integer> withCount : counts.entrySet()) {
            int key = withCount.getKey();
            int val = withCount.getValue();
            int minIdx = minIndexes.get(key);
            int maxIdx = maxIndexes.get(key);

            if (val != maxDegree) continue;
            minSubArraySize = Math.min(minSubArraySize, maxIdx - minIdx + 1);
        }
        return minSubArraySize;
    }
}
