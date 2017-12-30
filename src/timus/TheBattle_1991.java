package timus;

import java.util.Scanner;

public class TheBattle_1991 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int a[] = new int[n];
        int k = x.nextInt();
        int t1 = 0, t2 = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = x.nextInt();
            if (k - a[i] > 0) {
                t2 += k - a[i];
            } else {
                t1 += a[i] - k;
            }
        }
        System.out.println(t1 + " " + t2);
    }
}
