package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimizeMaxPairSumArray_1877 {

    // Time complexity: O(nlogn). Space complexity: O(n)
    public int minPairSum1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) list.add(nums[i] + nums[nums.length - i - 1]);
        return Collections.max(list);
    }

    // Time complexity: O(n). Space complexity: O(n)
    public int minPairSum(int[] nums) {
        int[] sums = new int[100001];
        List<Integer> list = new ArrayList<>();
        int left = 0, right = sums.length - 1;

        for (int num : nums) sums[num]++;

        while (left < right) {
            while (left < right && sums[left] == 0) left++;
            while (left < right && sums[right] == 0) right--;

            list.add(left + right);
            sums[left]--;
            sums[right]--;
            if (sums[left] <= 0) left++;
            if (sums[right] <= 0) right--;
        }
        return Collections.max(list);
    }
}
