package leetcode_problems.medium;

import java.util.*;

public class TaskScheduler_621 {

    // Time complexity: O(Tlog26) -> O(T) where T is length of the tasks
    // Space complexity: O(n)
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, (a, b) -> b - a);

        for(char c: tasks) counts[c - 'A']++;
        for (int j : counts) {
            if (j > 0) pq.offer(j);
        }

        int time = 0;
        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int tasksRun = 0;
            for(int i = 0; !pq.isEmpty() && i < n + 1; i ++) {
                int count = pq.poll();
                if(count > 1) temp.add(count - 1);
                tasksRun++;
            }
            time += temp.isEmpty() ? tasksRun : n + 1;
            for(int t: temp) pq.offer(t);
        }
        return time;
    }
}
