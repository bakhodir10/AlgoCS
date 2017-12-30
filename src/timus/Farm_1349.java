package timus;

import java.util.Scanner;

public class Farm_1349 {
    public static void main(String[] args) {
        int n;
        boolean b = false;
        Scanner x = new Scanner(System.in);
        n = x.nextInt();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= j; k++) {
                    if ((int) Math.pow(k, n) + (int) Math.pow(j, n) == (int) Math.pow(i, n) &&
                            ((int) Math.pow(k, n) != (int) Math.pow(j, n) && (int) Math.pow(k, n) != (int) Math.pow(i, n)
                                    && (int) Math.pow(j, n) != (int) Math.pow(i, n))) {
                        b = true;
                        System.out.println(k + " " + j + " " + i);
                        return;
                    }
                }
            }
        }
        if (!b) System.out.println(-1);
    }
}
