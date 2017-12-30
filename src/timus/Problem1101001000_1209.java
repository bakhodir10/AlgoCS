package timus;

import java.util.Scanner;

public class Problem1101001000_1209 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        for (int i = 0; i < n; i++) {
            int a = x.nextInt();
            funct(a);
        }
    }

    private static void funct(int x) {
        int a[] = new int[280];
        a[0] = 1;
        int t = 1, ans = 0;
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] + t;
            t++;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (x != a[j]) {
                    ans = 0;
                } else {
                    ans = 1;
                    break;
                }
            }
        }
        System.out.print(ans + " ");
    }
}
