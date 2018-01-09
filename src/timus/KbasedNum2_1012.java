package timus;

import java.math.BigInteger;
import java.util.Scanner;

public class KbasedNum2_1012 {
    public static void main(String[] args) {
        String k;
        int i, n;
        BigInteger[] a = new BigInteger[1801];
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.next();
        BigInteger e = new BigInteger(k);
        BigInteger f1 = new BigInteger(String.valueOf(1));
        a[0] = e.subtract(f1);
        a[1] = e.multiply(a[0]);
        for (i = 2; i < n; i++) {
            a[i] = (a[i - 1].add(a[i - 2])).multiply(e.subtract(f1));
        }
        System.out.print(a[((n - 1))]);
    }
}
