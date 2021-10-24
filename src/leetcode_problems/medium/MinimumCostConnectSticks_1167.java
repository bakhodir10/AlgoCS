package leetcode_problems.medium;

import java.util.PriorityQueue;

public class MinimumCostConnectSticks_1167 {

    // Time complexity: O(nlogn). Space complexity: O(n)
    public int connectSticks(int[] sticks) {
        int totalCost = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for (int stick : sticks) pQ.offer(stick);

        while (pQ.size() > 1) {
            int smallest = pQ.poll();
            int secondSmallest = pQ.poll();
            int cost = smallest + secondSmallest;
            totalCost += cost;

            pQ.offer(cost);
        }
        return totalCost;
    }
}