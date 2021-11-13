package leetcode_problems.hard;

import java.util.LinkedList;

public class SlidingWindowMaximum_239 {

    // Approach 1. Brute force. Time complexity: O(n^2). Space complexity: O(n). Note: This will get TLE
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] maxs = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) max = Math.max(max, nums[j]);
            maxs[i] = max;
        }
        return maxs;
    }

    // Approach 2. Using Dequeue. Time complexity: O(n). Space complexity: O(n)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int idx = 0;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> dQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!dQ.isEmpty() && dQ.getFirst() < i - k + 1) {
                dQ.removeFirst();
            }
            while (!dQ.isEmpty() && nums[dQ.getLast()] <= nums[i]) {
                dQ.removeLast();
            }
            dQ.addLast(i);
            if (i >= k - 1) {
                res[idx++] = nums[dQ.getFirst()];
            }
        }
        return res;
    }
}
