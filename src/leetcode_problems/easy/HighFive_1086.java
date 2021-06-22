package leetcode_problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive_1086 {

    // Time complexity: O(n*logn). Space complexity: O(n)
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item : items) {
            PriorityQueue<Integer> pQ = map.getOrDefault(item[0], new PriorityQueue<>(5));
            pQ.offer(item[1]);
            if (pQ.size() > 5) pQ.poll();
            map.put(item[0], pQ);
        }

        int[][] res = new int[map.size()][2];
        int i = 0;

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int sum = 0;
            int id = entry.getKey();
            PriorityQueue<Integer> pQ = entry.getValue();

            while (!pQ.isEmpty()) sum += pQ.poll();

            res[i][0] = id;
            res[i++][1] = sum / 5;
        }
        return res;
    }
}
