package timus;

import java.util.Scanner;

public class BritishScientists_1925 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), k = x.nextInt();
        int t1 = 0, t2 = 0, a, b, s = 0;
        for (int i = 0; i < n; i++) {
            a = x.nextInt();
            b = x.nextInt();
            t1 += a;
            t2 += b;
        }
        s = t1 - t2 + k - 2 * (n + 1);
        if (s >= 0) System.out.println(s);
        else
            System.out.println("Big Bang!");
    }
}
