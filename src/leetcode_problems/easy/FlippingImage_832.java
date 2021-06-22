package leetcode_problems.easy;

public class FlippingImage_832 {
    public static int[][] flipAndInvertImage(int a[][]) {
        int res[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                res[i][j] = a[i][a[i].length - 1 - j] == 1 ? 0 : 1;
        }
        return res;
    }
}
