package problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberRecentCalls_933 {

    private Queue<Integer> queue;

    public NumberRecentCalls_933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && t - queue.peek() > 3000) queue.poll();
        return queue.size();
    }
}
