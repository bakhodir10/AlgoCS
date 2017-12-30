package timus;

import java.util.Arrays;
import java.util.Scanner;

public class DemocracyinDanger_1025 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), s = 0;
        int a[] = new int[n];
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = x.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = a[i] / 2 + 1;
        }
        Arrays.sort(c);
        for (int i = 0; i <= c.length / 2; i++) {
            s += c[i];
        }
        System.out.println(s);
    }
}
