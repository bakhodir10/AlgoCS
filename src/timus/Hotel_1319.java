package timus;

import java.util.Scanner;

public class Hotel_1319 {
    public static void main(String[] args) {
        int n, k = 0;
        Scanner x = new Scanner(System.in);
        n = x.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < n && n - i + j - 1 >= 0 && n - i + j - 1 < n) a[j][n - i + j - 1] = ++k;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " \t");
            }
            System.out.println();
        }
    }
}
