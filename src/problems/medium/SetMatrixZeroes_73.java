package problems.medium;

public class SetMatrixZeroes_73 {
    public static void setZeroes(int[][] matrix) {
        if (matrix[0].length == 0) return;
        int n = matrix.length, m = matrix[0].length;
        boolean b[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) b[i][k] = true;
                    for (int k = 0; k < n; k++) b[k][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j]) matrix[i][j] = 0;
            }
        }
    }
}
