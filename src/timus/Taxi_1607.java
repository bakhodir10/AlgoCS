package timus;

import java.util.Scanner;

public class Taxi_1607 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a, b, x, y, i = 0;
        a = in.nextLong();
        x = in.nextLong();
        b = in.nextLong();
        y = in.nextLong();
        if (a >= b) {
            System.out.println(a);
            return;
        }
        while (a <= b) {
            if (a + x >= b) {
                System.out.println(b);
                return;
            }
            a += x;
            b -= y;
        }
        System.out.println(a);
    }

}
