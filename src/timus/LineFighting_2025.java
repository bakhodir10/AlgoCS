package timus;

import java.util.Scanner;

public class LineFighting_2025 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(solve(x.nextInt(), x.nextInt()));
        }
    }

    public static long solve(int n, int k){
        int a[] = new int[k], t = 0;
        long res = 0;

        for (int i = 0; i < (n % k == 0 ? n / k : n % k); i++) {
            if (i < a.length)  a[i] = n % k  == 0 ? n / k : n / k + 1;
            t++;
        }

        for (int i = t; i < a.length; i++) {
            a[i] =  n / k;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                res += a[i] * a[j];
            }
        }
        return res;
    }
}
