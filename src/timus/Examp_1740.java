package timus;

import java.util.Scanner;

public class Examp_1740 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int k = x.nextInt(), l = x.nextInt(), h = x.nextInt(), d = 0;
        float max = 0, min;
        while (k > d) {
            d += l;
            max += h;
        }
        min = (k / l) * h;
        System.out.printf("%.5f", min);
        System.out.print(" ");
        System.out.printf("%.5f", max);
    }
}
