package leetcode_problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByIncreasingFrequency_1636 {

    record Pair(int num, int count){};

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> {
            if(e1.count != e2.count) return e1.count - e2.count;
            else return e2.num - e1.num;
        });

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int index = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            for(int j = 0; j < p.count; j ++) nums[index++] = p.num;
        }
        return nums;
    }
}
