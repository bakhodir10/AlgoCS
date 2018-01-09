package timus;

import java.util.Scanner;

public class Maximum_1079 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        while (x.hasNextInt()) {
            int d = x.nextInt();
            if (d != 0) {
                func(d);
            } else {
                System.exit(0);
            }
        }
    }

    private static void func(int c) {
        long a[] = new long[c + 1], max = 0;
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= c; i++) {
            if (i % 2 == 0) {
                a[i] = a[i / 2];
            } else {
                a[i] = a[i / 2] + a[i / 2 + 1];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        if (c == 1) {
            System.out.println(1);
        } else
            System.out.println(max);
    }
}
