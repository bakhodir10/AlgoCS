package timus;

import java.util.Scanner;

public class ReverseRoot_1001 {
    public static void main(String[] args) {
        int i = 0, t = 0;
        double a[] = new double[999999];
        Scanner x = new Scanner(System.in);
        a[i++] = Math.sqrt(x.nextDouble());
        t++;
        while (x.hasNextDouble()) {
            double d = x.nextDouble();
            a[i++] = Math.sqrt(d);
            t++;
        }
        for (int j = t - 1; j >= 0; j--) {
            System.out.printf("%.4f\n", a[j]);
        }
    }
}
