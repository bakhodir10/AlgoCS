package leetcode_problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededBuyTickets_5926 {

    // Time complexity: O(n*k). Memory complexity: O(n)
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 1;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) q.add(new int[]{tickets[i], i});

        while (!q.isEmpty()) {
            int[] item = q.poll();
            item[0] -= 1;
            if (item[0] == 0 && item[1] == k) return time;
            if (item[0] != 0) q.add(item);
            time++;
        }
        return time;
    }
}
