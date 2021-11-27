package leetcode_problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {

    // Time complexity: O(m^n). Space complexity: O(m^n)
    public int orangesRotting(int[][] matrix) {
        if (matrix.length == 0) return 0;

        int time = 0;
        int m = matrix[0].length;
        int n = matrix.length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] idx = q.poll();
                int row = idx[0];
                int col = idx[1];

                if (col - 1 >= 0 && matrix[row][col - 1] == 1) {  // left
                    matrix[row][col - 1] = 2;
                    q.offer(new int[]{row, col - 1});
                }
                if (row - 1 >= 0 && matrix[row - 1][col] == 1) {  // top
                    matrix[row - 1][col] = 2;
                    q.offer(new int[]{row - 1, col});
                }
                if (col + 1 < m && matrix[row][col + 1] == 1) { // right
                    matrix[row][col + 1] = 2;
                    q.offer(new int[]{row, col + 1});
                }
                if (row + 1 < n && matrix[row + 1][col] == 1) { // bottom
                    matrix[row + 1][col] = 2;
                    q.offer(new int[]{row + 1, col});
                }
            }
            time++;
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == 1) return -1;
            }
        }
        return time == 0 ? time : time - 1;
    }
}
