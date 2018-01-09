package timus;

import java.util.Scanner;

public class AWhole_1644 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int max = Integer.MIN_VALUE, min = 10;
        if (n == 0) {
            System.out.println(10);
            return;
        }
        for (int i = 0; i < n; i++) {
            int d = x.nextInt();
            String s = x.next();
            if (s.equals("hungry")) {
                if (d > max) max = d;
            }
            if (s.equals("satisfied")) {
                if (d < min) min = d;
            }
        }
        if (max >= min) {
            System.out.println("Inconsistent");
        } else
            System.out.println(min);
    }
}
