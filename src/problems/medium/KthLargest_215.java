package problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest_215 {

    // Time complexity O(nlog(n)). Memory complexity O(n)
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Time complexity O(nlog(k)). Memory complexity O(k)
    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> pQ = new PriorityQueue<>(k);

        for (int num : nums) {
            pQ.offer(num);
            if (pQ.size() > k) pQ.poll();
        }
        return pQ.peek();
    }

    // Time complexity: Best O(n), Worst O(n*n). Memory complexity O(1). Using Quick Select algorithm
    public int findKthLargest3(int[] nums, int k) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right, (left + right) / 2);
            if (pivotIndex == nums.length - k) return nums[nums.length - k];
            else if (pivotIndex < nums.length - k) left = pivotIndex + 1;
            else right = pivotIndex - 1;
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storedIndex = left;

        for (int i = left; i <= right - 1; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storedIndex, i);
                storedIndex++;
            }
        }
        swap(nums, right, storedIndex);
        return storedIndex;
    }

    private void swap(int[] nums, int index1, int index2) {
        int c = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = c;
    }
}