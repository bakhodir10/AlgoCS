package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree_2032 {

    // Time complexity: O(n). Space complexity: O(n)
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] nums = new int[101];

        Set<Integer> set = convertToSet(nums1);
        for (int num : set) nums[num]++;

        set = convertToSet(nums2);
        for (int num : set) nums[num]++;

        set = convertToSet(nums3);
        for (int num : set) nums[num]++;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 2) result.add(i);
        }
        return result;
    }

    private Set<Integer> convertToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        return set;
    }
}
