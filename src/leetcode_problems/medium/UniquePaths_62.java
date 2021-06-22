package leetcode_problems.medium;

public class UniquePaths_62 {
    public static int uniquePaths(int m, int n) {
        int table[][] = new int[m][n];

        for (int i = 0; i < n; i++) table[0][i] = 1;
        for (int i = 0; i < m; i++) table[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = table[i][j - 1] + table[i - 1][j];
            }
        }
        return table[m - 1][n - 1];
    }
}
