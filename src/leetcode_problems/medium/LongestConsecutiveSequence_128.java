package leetcode_problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    // Time complexity: O(nlogn). Space complexity: O(1)
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int max = 0;
        int maxSoFar = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] - 1 == nums[i - 1]) maxSoFar++;
            else {
                max = Math.max(max, maxSoFar);
                maxSoFar = 1;
            }
        }
        return Math.max(max, maxSoFar);
    }

    // Time complexity: O(n). Space complexity: O(1)
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int maxSoFar = 0;

                while (set.contains(num)) {
                    num++;
                    maxSoFar++;
                }
                max = Math.max(max, maxSoFar);
            }
        }
        return max;
    }
}