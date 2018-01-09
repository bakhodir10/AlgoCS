package timus;

import java.util.Scanner;

public class Rope_1020 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        double r = x.nextDouble();
        double PI = Math.PI;
        double a[][] = new double[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = x.nextDouble();
            }
        }
        double sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += func(a[i][0], a[i + 1][0], a[i][1], a[i + 1][1]);
        }
        sum += func(a[0][0], a[n - 1][0], a[0][1], a[n - 1][1]) + 2 * PI * r;
        System.out.printf("%.2f", sum);
    }

    private static double func(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
