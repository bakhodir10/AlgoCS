package leetcode_problems.easy;

public class RangeAdditionII_598 {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int minX = ops[0][0], minY = ops[0][1];
        for (int[] op : ops) {
            if (op[0] < minX) minX = op[0];
            if (op[1] < minY) minY = op[1];
        }
        return minX * minY;
    }
}