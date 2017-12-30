package timus;

import java.util.Scanner;

public class Power_1110 {
    public static int power(int x, int n, int m) {
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = (res * x) % m;
            x = (x * x) % m;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n, m, y, x;
        boolean b = true;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        y = in.nextInt();
        for (int i = 0; i < m; i++) {
            if (power(i, n, m) == y) {
                System.out.print(i + " ");
                b = false;
            }
        }
        if (b) System.out.print(-1);
    }
}
