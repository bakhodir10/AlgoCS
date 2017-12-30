package timus;

import java.util.Scanner;

public class PsychUpsEigenvalues_1880 {
    public static void main(String[] args) {
        long a[] = new long[4001], n, b[] = new long[4001], c[] = new long[4001],
                m, x[] = new long[4001], t = 0, z;

        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();

        m = sc.nextLong();
        for (int j = 0; j < m; j++) b[j] = sc.nextLong();

        z = sc.nextLong();
        for (int i = 0; i < z; i++) x[i] = sc.nextLong();

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (a[i] == b[j]) {
                    c[k] = b[j];
                    k++;
                }
        }


        for (int i = 0; i < k; i++) {
            for (int j = 0; j < z; j++)
                if (c[i] == x[j]) t++;
        }
        System.out.println(t);
    }
}
