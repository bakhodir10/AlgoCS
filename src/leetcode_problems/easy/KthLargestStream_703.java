package leetcode_problems.easy;

import java.util.PriorityQueue;
import java.util.Queue;

// Time complexity O(nlog(k)). Memory complexity O(k)
public class KthLargestStream_703 {

    private final Queue<Integer> pQ;
    private final int k;

    public KthLargestStream_703(int k, int[] nums) {
        this.k = k;
        pQ = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            pQ.offer(num);
            if (pQ.size() > k) pQ.poll();
        }
    }

    public int add(int val) {
        pQ.offer(val);
        if (pQ.size() > k) pQ.poll();
        return pQ.peek();
    }
}
