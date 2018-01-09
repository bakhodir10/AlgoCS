package timus;

import java.util.Scanner;

public class ProductDigits_1014 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        System.out.println(number(n));
    }

    private static long number(long n) {
        if (n == 0) return 10;
        if (n == 1) return 1;
        long ans = 0, p = 1;
        for (int i = 9; i >= 2; i--) {
            while (n % i == 0) {
                ans += p * i;
                p = p * 10;
                n /= i;
            }
        }
        return n == 1 ? ans : -1;
    }
}
