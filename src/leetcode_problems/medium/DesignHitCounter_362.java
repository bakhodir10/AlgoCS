package leetcode_problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignHitCounter_362 {

    // Follow up: What if the number of hits per second could be huge? Does your design scale?

    private static class Pair {
        int timestamp;
        int count;

        public Pair(int timestamp, int count) {
            this.timestamp = timestamp;
            this.count = count;
        }
    }

    private int total;
    private final Deque<Pair> q;

    public DesignHitCounter_362() {
        this.total = 0;
        this.q = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        if (q.isEmpty() || q.peekFirst().timestamp != timestamp) {
            q.offer(new Pair(timestamp, 1));
        } else {
            Pair p = q.removeLast();
            p.count++;
            q.addLast(p);
        }
        total++;
    }

    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp >= q.peekFirst().timestamp + 300) {
            total -= q.removeFirst().count;
        }
        return total;
    }

    // Simple implementation without considering multiple hits at the same timestamp

    /*
    public int getHits(int timestamp) {
        while (!q.isEmpty() && timestamp >= q.peekFirst().timestamp + 300) {
            total -= q.removeFirst().count;
        }
        return total;
    }

    Deque<Integer> q;
    public DesignHitCounter_362() {
        this.q = new ArrayDeque<>();
    }

    private void cleanUp(int timestamp) {
        while(!q.isEmpty() && timestamp >= q.peek() + 300) q.poll();
    }

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    public int getHits(int timestamp) {
        cleanUp(timestamp);
        return q.size();
    }
   */
}
