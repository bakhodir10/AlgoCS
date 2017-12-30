package timus;

import java.util.Scanner;

public class UralSteaks_1820 {
    public static void main(String[] args) {
        double a, b;
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        if (a <= b) {
            System.out.println(2);
            return;
        }
        if (b == 1) {
            System.out.println((int) a * 2);
            return;
        }
        System.out.println((int) Math.ceil((a * 2) / b));
    }
}
