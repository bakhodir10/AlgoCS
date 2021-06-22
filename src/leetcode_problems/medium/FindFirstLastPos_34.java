package leetcode_problems.medium;

import java.util.Arrays;

public class FindFirstLastPos_34 {

    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) return new int[]{-1, -1};
        int start = findStart(nums, target, 0, index);
        int end = findEnd(nums, target, index, nums.length - 1);

        return new int[]{start, end};
    }

    private int findStart(int nums[], int t, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] != t) l = m + 1;
            else r = m - 1;
        }
        return l;
    }

    private int findEnd(int nums[], int t, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == t) l = m + 1;
            else r = m - 1;
        }
        return r;
    }
}
