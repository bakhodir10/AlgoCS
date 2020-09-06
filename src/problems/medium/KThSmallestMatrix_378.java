package problems.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KThSmallestMatrix_378 {

    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pQ = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int[] row : matrix) {
            for (int num : row) {
                pQ.offer(num);
                if (pQ.size() > k) pQ.poll();
            }
        }
        return pQ.peek();
    }
}