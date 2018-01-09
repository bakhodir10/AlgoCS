package timus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Stripies_1161 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Byte n = in.nextByte();
        double ans = 0;
        double a[] = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        ans = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            ans = Max(ans, a[i - 1]);
        }
        System.out.printf("%.2f", ans);
    }

    private static double Max(double x, double y) {
        return 2 * Math.sqrt(x * y);
    }
}
