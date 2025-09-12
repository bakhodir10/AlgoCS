package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    // Time complexity: O(n*m)
    // Space complexity: O(n*m)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowCount = matrix.length, colCount = matrix[0].length;
        int left = 0, right = colCount - 1, up = 0, down = rowCount - 1;

        while (res.size() < rowCount * colCount) {
            if (res.size() >= rowCount * colCount) break;
            for (int col = left; col <= right; col++) res.add(matrix[up][col]);

            if (res.size() >= rowCount * colCount) break;
            for (int row = up + 1; row <= down; row++) res.add(matrix[row][right]);

            if (res.size() >= rowCount * colCount) break;
            for (int col = right - 1; col >= left; col--) res.add(matrix[down][col]);

            if (res.size() >= rowCount * colCount) break;
            for (int row = down - 1; row > up; row--) res.add(matrix[row][left]);

            up++;
            left++;
            right--;
            down--;
        }
        return res;
    }
}
