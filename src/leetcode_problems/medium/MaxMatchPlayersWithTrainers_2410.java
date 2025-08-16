package leetcode_problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxMatchPlayersWithTrainers_2410 {

    // Time complexity: O(nlogn + mlogm) where n -> length of the players, m -> length of trainers
    // Space complexity: O(n + m)
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int count = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for(int player: players) pq1.offer(player);
        for(int trainer: trainers) pq2.offer(trainer);

        while(!pq1.isEmpty() && !pq2.isEmpty()) {
            int player = pq1.poll();
            while(!pq2.isEmpty() && player > pq2.peek()) {
                pq2.poll();
            }
            if(!pq2.isEmpty()) {
                count++;
                pq2.poll();
            }
        }
        return count;
    }

    // Time complexity: O(nlogn + mlogm) where n -> length of the players, m -> length of trainers
    // Space complexity: O(logn + logm). Java sorting algorithm takes logn and logm space.
    public int matchPlayersAndTrainers1(int[] players, int[] trainers) {
        int count = 0, p1 = 0, p2 = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        while(p1 < players.length) {
            int player = players[p1];
            while(p2 < trainers.length && player > trainers[p2]) p2++;
            if(p2 < trainers.length) count++;
            p1++;
            p2++;
        }
        return count;
    }
}
