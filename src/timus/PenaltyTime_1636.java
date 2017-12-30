package timus;

import java.util.Scanner;

public class PenaltyTime_1636 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int a = x.nextInt();
        int b = x.nextInt();
        int s = 0;
        for (int i = 0; i < 10; i++) {
            int d = x.nextInt();
            s += 20 * d;
        }
        if (a <= b - s) System.out.println("No chance.");
        else
            System.out.println("Dirty debug :(");
    }
}
