package leetcode_problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsOrigin_973 {

    // Time complexity O(nlog(n)). Memory complexity O(n)
    public int[][] kClosest1(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    // Time complexity O(nlog(k)). Memory complexity O(k)
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> pQ = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

        int[][] res = new int[k][];
        for (int[] point : points) {
            pQ.offer(point);
            if (pQ.size() > k) pQ.poll();
        }

        while (!pQ.isEmpty()) {
            res[--k] = pQ.poll();
        }
        return res;
    }

    // Time complexity: average -> O(n). Worst case: O(n^2). Memory complexity O(1)
    public int[][] kClosest3(int[][] points, int k) {
        int left = 0, right = points.length - 1, idx = 0;

        while (left <= right) {
            int pivotIndex = partition(points, left, right);
            if (pivotIndex == k) break;
            else if (pivotIndex < k) left = pivotIndex + 1;
            else right = pivotIndex - 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (compare(points[j], pivot) < 0) {
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, right);
        return i;
    }

    private void swap(int[][] points, int idx1, int idx2) {
        int[] temp = points[idx1];
        points[idx1] = points[idx2];
        points[idx2] = temp;
    }

    private int compare(int[] p1, int[] p2) {
        return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
    }
}
