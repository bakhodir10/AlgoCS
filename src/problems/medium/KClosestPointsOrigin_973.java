package problems.medium;

import java.util.Set;
import java.util.TreeSet;

public class KClosestPointsOrigin_973 {

    public int[][] kClosest(int[][] points, int k) {

        Set<Pair> pairsInOrder = new TreeSet<>();
        for (int[] point : points) {
            pairsInOrder.add(new Pair(point[0], point[1]));
        }

        int[][] res = new int[k][2];
        int i = 0;

        for (Pair p : pairsInOrder) {
            if (k > i) res[i++] = new int[]{p.x, p.y};
            else break;
        }

        return res;
    }

    class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return Math.sqrt(this.x * this.x + this.y * this.y) >= Math.sqrt(o.x * o.x + o.y * o.y) ? 1 : -1;
        }
    }
}
