package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence_300 {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i ++) {
            if(list.getLast() < nums[i]) {
                list.add(nums[i]);
            } else {
                int j = 0;
                while(j < list.size() && list.get(j) < nums[i]) {
                    j++;
                }
                list.set(j, nums[i]);
            }
        }
        return list.size();
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public int lengthOfLIS2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i ++) {
            if(list.getLast() < nums[i]) {
                list.add(nums[i]);
            } else {
                int idx = Collections.binarySearch(list, nums[i]);
                if(idx < 0) list.set(Math.abs(idx) - 1, nums[i]);
            }
        }
        return list.size();
    }
}
