package timus;

import java.util.Scanner;

public class StonePile_1005 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int a[] = new int[n];
        long min = Integer.MAX_VALUE, sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = x.nextInt();
        }
        for (int i = 0; i < Math.pow(2, n); i++) {
            int b[];
            b = Binary(n, i);
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < n; j++) {
                if (b[j] == 0) sum1 += a[j];
                if (b[j] == 1) sum2 += a[j];
            }
            if (Math.abs(sum1 - sum2) < min) {
                min = Math.abs(sum1 - sum2);
            }
        }
        System.out.println(min);
    }

    public static int[] Binary(int n, int m) {
        int[] a = new int[n];
        int i = 0;
        while (m != 0) {
            a[i++] = m % 2;
            m /= 2;
        }
        return a;
    }
}
