package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndices_5938 {

    //  Time complexity: O(nlogn). Space complexity: O(1)
    public List<Integer> targetIndices1(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) res.add(i);
        }
        return res;
    }

    //  Time complexity: O(n). Space complexity: O(1)
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] arr = new int[101];
        int idx = 0;
        List<Integer> res = new ArrayList<>();

        for (int num : nums) arr[num]++;

        for (int i = 1; i < arr.length; i++) {
            if (i != target) idx += arr[i];
            else {
                for (int j = 0; j < arr[i]; j++) res.add(idx++);
            }
        }
        return res;
    }
}
