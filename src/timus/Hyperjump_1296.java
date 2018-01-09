package timus;

import java.util.Scanner;

public class Hyperjump_1296 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), a;
        long count = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            a = x.nextInt();
            count += a;
            if (count < 0) count = 0;
            ans = Math.max(count, ans);
        }
        System.out.println(ans);
    }
}
