package timus;

import java.util.Scanner;

public class Spiral_1224 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        long n = x.nextInt();
        long m = x.nextInt();
        if (n <= m) {
            System.out.println(2 * n - 2);
        } else {
            System.out.println(2 * m - 1);
        }
    }
}
