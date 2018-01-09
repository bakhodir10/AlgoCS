package timus;

import java.util.Arrays;
import java.util.Scanner;

public class TaxiProgramm_2005 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        long a[][] = new long[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = x.nextInt();
            }
        }
        long s1 = a[0][1] + a[1][2] + a[2][3] + a[3][4];
        long s2 = a[0][2] + a[2][1] + a[1][3] + a[3][4];
        long s3 = a[0][2] + a[2][3] + a[3][1] + a[1][4];
        long s4 = a[0][3] + a[3][2] + a[2][1] + a[1][4];
        if (min(s1, s2, s3, s4) == s1) {
            System.out.println(s1);
            System.out.println("1 2 3 4 5");
            return;
        }
        if (min(s1, s2, s3, s4) == s2) {
            System.out.println(s2);
            System.out.println("1 3 2 4 5");
            return;
        }
        if (min(s1, s2, s3, s4) == s3) {
            System.out.println(s3);
            System.out.println("1 3 4 2 5");
            return;
        }
        if (min(s1, s2, s3, s4) == s4) {
            System.out.println(s4);
            System.out.println("1 4 3 2 5");
            return;
        }
    }

    public static long min(long a, long b, long c, long d) {
        long f[] = {a, b, c, d};
        Arrays.sort(f);
        return f[0];
    }
}