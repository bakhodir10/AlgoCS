package problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimizeProductSum_1874 {

    // approach 1. Time complexity: O(nlogn + mlogm). Space complexity: O(n + m)
    public int minProductSum1(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> p1 = new PriorityQueue<>((e1, e2) -> e2 - e1);
        PriorityQueue<Integer> p2 = new PriorityQueue<>();

        for (int num : nums1) p1.offer(num);
        for (int num : nums2) p2.offer(num);

        int sum = 0;
        while (!p1.isEmpty() && !p2.isEmpty()) sum += p1.poll() * p2.poll();
        return sum;
    }

    // approach 1. Time complexity: O(nlogn + mlogm). Space complexity: O(n + m)
    public int minProductSum2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) sum += nums1[i] * nums2[nums2.length - i - 1];
        return sum;
    }
}
