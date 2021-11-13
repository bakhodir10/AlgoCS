package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberUniqueIntegers_1481 {

    // Time complexity: O(nlogn). Memory complexity: O(n)
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> nums = new HashMap<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for (int num : arr) nums.put(num, nums.getOrDefault(num, 0) + 1);
        for (int val : nums.values()) pQ.offer(val);

        while (!pQ.isEmpty() && k > 0) {
            int val = pQ.poll();
            if (k < val) pQ.offer(val - k);
            k -= val;
        }
        return pQ.size();
    }
}
