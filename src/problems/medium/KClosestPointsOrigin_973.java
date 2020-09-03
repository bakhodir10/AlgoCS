package problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsOrigin_973 {

    // Time complexity O(nlog(k)). Memory complexity O(k)
    public int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<Pair> pQ = new PriorityQueue<>(k + 1);
        int[][] res = new int[k][2];

        for (int[] point : points) {
            pQ.offer(new Pair(point[0], point[1]));
            if (pQ.size() > k) pQ.poll();
        }
        while (!pQ.isEmpty()) {
            res[--k] = new int[]{pQ.peek().x, pQ.poll().y};
        }
        return res;
    }

    // Time complexity O(nlog(n)). Memory complexity O(n)
    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] + p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, k);
    }

    private static class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return (o.x * o.x + o.y * o.y) - (this.x * this.x + this.y * this.y);
        }
    }
}
