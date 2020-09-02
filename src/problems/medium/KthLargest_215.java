package problems.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest_215 {

    // Time complexity O(nlog(k)). Memory complexity O(k)
    public int findKthLargest1(int[] nums, int k) {
        Queue<Integer> pQ = new PriorityQueue<>();

        for (int num : nums) {
            pQ.offer(num);
            if (pQ.size() > k) pQ.poll();
        }
        return pQ.peek();
    }

    // todo
    // Time complexity: Best O(n), Worst O(n*n). Memory complexity O(1). Using Quick Select algorithm
    public int findKthLargest2(int[] nums, int k) {
        return -1;
    }
}
