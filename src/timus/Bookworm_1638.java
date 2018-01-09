package timus;

import java.util.Scanner;

public class Bookworm_1638 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int a = x.nextInt();
        int b = x.nextInt();
        int c = x.nextInt();
        int d = x.nextInt();
        System.out.println(Math.abs((d - c - 1) * a + (d - c) * b * 2));
    }
}
