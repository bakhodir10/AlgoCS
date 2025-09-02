package leetcode_problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs_1679 {


    // Time complexity: O(n)
    // Space complexity: O(n)
    public int maxOperations1(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> freqs = new HashMap<>();

        for(int num: nums) {
            if(freqs.containsKey(k - num)) {
                count++;
                int c = freqs.get(k - num);
                if(c <= 1) freqs.remove(k - num);
                else freqs.put(k - num, c - 1);
            } else {
                freqs.put(num, freqs.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, count = 0;

        while(l < r) {
            int currSum = nums[l] + nums[r];
            if(currSum == k) {
                l++;
                r--;
                count++;
            } else if(currSum < k){
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
