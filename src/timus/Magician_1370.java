package timus;

import java.util.Scanner;

public class Magician_1370 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int m = x.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = x.nextInt();
        }
        for (int i = m; i < m + 10; i++) {
            System.out.print(a[i % n]);
        }
    }
}
