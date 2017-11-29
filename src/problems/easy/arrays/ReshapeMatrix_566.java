package problems.easy.arrays;

public class ReshapeMatrix_566 {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (n * m < r * c) {
            r = n;
            c = m;
        }
        int[][] a = new int[r][c];
        int b[] = new int[n * m];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                b[k++] = nums[i][j];
            }
        }
        k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = b[k++];
            }
        }
        return a;
    }
}