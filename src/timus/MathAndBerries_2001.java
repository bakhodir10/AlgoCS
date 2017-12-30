package timus;

import java.util.Scanner;

public class MathAndBerries_2001 {
    public static void main(String[] args) {
        int n = 6, i, a[] = new int[7];
        Scanner x = new Scanner(System.in);
        for (i = 1; i <= n; i++) a[i] = x.nextInt();
        System.out.println((a[1] - a[5]) + " " + (a[2] - a[4]));
    }
}
