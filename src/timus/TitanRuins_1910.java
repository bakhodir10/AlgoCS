package timus;

import java.util.Scanner;

public class TitanRuins_1910 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong(), x = 0, max = 0, s = 0;
        int a[] = new int[(int) n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        if (n >= 3) {
            for (int i = 1; i < a.length - 1; i++) {
                s = a[i] + a[i - 1] + a[i + 1];
                if (s > max) {
                    max = s;
                    x = i;
                }
            }
        }
        System.out.print(max + " " + (x + 1));
    }
}
