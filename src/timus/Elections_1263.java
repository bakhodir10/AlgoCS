package timus;

import java.util.Scanner;

public class Elections_1263 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), m = x.nextInt();
        int b[] = new int[m + 1];
        int c[] = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            b[i] = x.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (b[i] == j) c[j]++;
            }
        }
        for (int j = 1; j <= n; j++) {
            c[j] *= 100;
            System.out.printf("%.2f", c[j] * 1. / m);
            System.out.println("%");
        }
    }
}