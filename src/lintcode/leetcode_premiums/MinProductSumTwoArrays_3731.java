package lintcode.leetcode_premiums;

import java.util.Arrays;

public class MinProductSumTwoArrays_3731 {

    // Time complexity: O(nlogn + mlogm)
    // Space complexity: O(logn + logm)
    public int minProductSum(int[] nums1, int[] nums2) {
        if(nums1.length != nums2.length) return -1;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        long sum = 0;

        for(int i = 0; i < nums1.length; i++) sum += (long) nums1[i] * nums2[nums2.length - i - 1];
        return (int)sum;
    }
}
