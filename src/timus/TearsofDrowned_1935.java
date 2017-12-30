package timus;

import java.util.Scanner;

public class TearsofDrowned_1935 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int a[] = new int[n];
        int d = 0, s = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = x.nextInt();
            s += a[i];
            if (a[i] > d) d = a[i];
        }
        s += d;
        System.out.println(s);
    }
}
