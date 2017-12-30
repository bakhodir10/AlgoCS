package timus;

import java.util.Scanner;

public class Factorials_1083 {
    public static void main(String[] args) {
        long n, d = 1;
        String s;
        Scanner x = new Scanner(System.in);
        n = x.nextInt();
        s = x.next();
        int len = s.length();
        while (n > 0) {
            d *= n;
            n -= len;
        }
        System.out.print(d);
    }
}
