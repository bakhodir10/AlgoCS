package problems.medium;

import java.util.PriorityQueue;

public class KClosestPointsOrigin_973 {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        int[][] res = new int[k][2];

        for (int[] point : points) {
            Pair pair = new Pair(point[0], point[1]);

            if (pQ.size() == k) {
                if (pQ.peek() != null && pQ.peek().compareTo(pair) < 0) {
                    pQ.poll();
                    pQ.add(pair);
                }
            } else pQ.add(pair);
        }
        int i = 0;
        while (!pQ.isEmpty()) {
            Pair p = pQ.poll();
            res[i++] = new int[]{p.x, p.y};
        }
        return res;
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
            return Math.sqrt(o.x * o.x + o.y * o.y) >= Math.sqrt(this.x * this.x + this.y * this.y) ? 1 : -1;
        }
    }
}
