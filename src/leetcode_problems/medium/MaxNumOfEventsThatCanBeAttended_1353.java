package leetcode_problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumOfEventsThatCanBeAttended_1353 {


    // n -> number of events, m = maximum number of days
    // Time complexity: O(n log n + m)
    // Space complexity: O(n)
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int maxDay = 0, eventIth = 0, attended = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] ev : events) maxDay = Math.max(maxDay, ev[1]);
        for (int day = 1; day <= maxDay; day++) {
            while (eventIth < events.length && events[eventIth][0] == day) {
                minHeap.offer(events[eventIth][1]);
                eventIth++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }
        }
        return attended;
    }

    // n -> number of events
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public int maxEvents2(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int day = 0, eventIth = 0, attended = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while(eventIth < events.length || !minHeap.isEmpty()) {
            if(minHeap.isEmpty()) day = events[eventIth][0];

            while(eventIth < events.length && events[eventIth][0] == day) {
                minHeap.offer(events[eventIth][1]);
                eventIth++;
            }

            while(!minHeap.isEmpty() && minHeap.peek() < day) minHeap.poll();

            if(!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
                day++;
            }
        }
        return attended;
    }
}
