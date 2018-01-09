package timus;

import java.util.Scanner;

public class DominoDots_1502 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        long s = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                s += i;
                s += j;
            }
        }
        System.out.println(s);
    }
}
