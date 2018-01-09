package timus;

import java.util.Scanner;

public class KbasedNumbers1009 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int i, n, k;
        int[] a = new int[20];
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        a[0] = k - 1;
        a[1] = k * a[0];
        for (i = 2; i < n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) * (k - 1);
        }
        System.out.print(a[n - 1]);
    }
}
