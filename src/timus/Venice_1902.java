package timus;

import java.util.Scanner;

public class Venice_1902 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, t;
        double s;
        n = in.nextInt();
        t = in.nextInt();
        s = in.nextDouble();
        for (int i = 0; i < n; i++) {
            System.out.printf("%.6f", s + (in.nextInt() - s + t) / 2);
            System.out.println();
        }
    }
}
