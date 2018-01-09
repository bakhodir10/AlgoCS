package timus;

import java.util.Scanner;

public class StrangeProcedure_1214 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        long a = x.nextLong(), b = x.nextLong();
        if ((a + b) % 2 == 0 || a <= 0 || b <= 0) System.out.println(a + " " + b);
        else
            System.out.println(b + " " + a);
    }
}
