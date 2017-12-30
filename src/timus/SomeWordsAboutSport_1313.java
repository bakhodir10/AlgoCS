package timus;

import java.util.Scanner;

public class SomeWordsAboutSport_1313 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < n && i - j < n)
                    System.out.print(a[i - j][j] + " ");
            }
        }
    }
}
