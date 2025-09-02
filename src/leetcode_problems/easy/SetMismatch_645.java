package leetcode_problems.easy;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch_645 {

    // Time complexity: O(n)
    // Time complexity: O(n)
    public int[] findErrorNums(int[] nums) {
        int[] dummy = new int[nums.length];
        int dup = 0, missing = 0;

        for (int num : nums) {
            if (dummy[num - 1] != 0) dup = num;
            dummy[num - 1] = num;
        }

        for(int i = 0; i < dummy.length; i ++) {
            if(dummy[i] == 0) missing = i + 1;
        }
        return new int[]{dup, missing};
    }

    // Time complexity: O(n)
    // Time complexity: O(n)
    public int[] findErrorNums2(int[] nums) {
        int dup = 0;
        Set<Integer> set = new HashSet<>();

        for(int num: nums) {
            if(set.contains(num)) dup = num;
            set.add(num);
        }

        for(int i = 1; i <= nums.length; i ++) {
            if(!set.contains(i)) return new int[]{dup, i};
        }
        return new int[]{};
    }

    // Time complexity: O(n)
    // Time complexity: O(1)
    public int[] findErrorNums3(int[] nums) {
        int dup = 0, missing = 0;
        for(int num: nums) {
            if(nums[Math.abs(num) - 1] < 0) dup = Math.abs(num);
            else nums[Math.abs(num) - 1] *= -1;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] > 0) missing = i + 1;
        }
        return new int[]{dup, missing};
    }
}
