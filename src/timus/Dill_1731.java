package timus;

import java.util.Scanner;

public class Dill_1731 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int a = x.nextInt();
        int b = x.nextInt();
        for (int i = 1; i <= a; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = a + 1; i <= a + b; i++) {
            System.out.print(i * a + " ");
        }
    }
}
