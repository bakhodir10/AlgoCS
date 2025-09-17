package leetcode_problems.medium;

import java.util.PriorityQueue;

public class LongestHappyString_1405 {

    private record Pair(char c, int count) {}

    // Time complexity: O(a + b + c)
    // Space complexity: O(a + b + c)
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p1 = pq.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == p1.c
                    && sb.charAt(sb.length() - 2) == p1.c) {
                if (pq.isEmpty()) break;
                Pair p2 = pq.poll();
                sb.append(p2.c);
                if (p2.count > 1) pq.offer(new Pair(p2.c, p2.count - 1));
                pq.offer(p1);
            } else {
                sb.append(p1.c);
                if (p1.count > 1) pq.offer(new Pair(p1.c, p1.count - 1));
            }
        }
        return sb.toString();
    }
}
