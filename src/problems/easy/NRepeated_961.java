package problems.easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeated_961 {

    // approach 1. Time complexity: O(N/2) ~ O(N). Memory complexity: O(N/2) ~ O(N)
    public int repeatedNTimes(int[] nums) {
        Set<Integer> numSeenSet = new HashSet<>();
        for (int i = 0; i <= nums.length / 2 + 1; i++) {
            if (numSeenSet.contains(nums[i])) return nums[i];
            numSeenSet.add(nums[i]);
        }
        return -1;
    }

    // approach 2 -> Majority and voting algorithm. Time complexity: O(N). Memory complexity: O(1)
    public int repeatedNTimes2(int[] nums) {
        int maj_i = 0, vote = 1;

        // find a majority in the nums
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[maj_i]) vote++;
            else vote--;

            if (vote == 0) {
                maj_i = i;
                vote = 1;
            }
        }

        int count = 0;
        for (int num : nums) {
            if (num == nums[maj_i]) count++;
        }
        // if the count is equal or greater than the half of the array then we already found the majority num
        if (count >= nums.length / 2) return nums[maj_i];
        // else the last one must be majority num to satisfy count of majority num > nums.length / 2
        else return nums[nums.length - 1];
    }
}