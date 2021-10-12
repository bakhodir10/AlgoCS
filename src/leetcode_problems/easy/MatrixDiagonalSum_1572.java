package leetcode_problems.easy;

public class MatrixDiagonalSum_1572 {

    // Time complexity: O(n). Space complexity: O(1)
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int i = 0; i < mat.length; i++) sum += mat[i][i];
        for (int i = 0; i < mat.length; i++) sum += mat[i][mat.length - i - 1];

        if (mat.length % 2 == 1) sum -= mat[mat.length / 2][mat.length / 2];
        return sum;
    }
}
