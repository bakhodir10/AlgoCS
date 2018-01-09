package timus;

import java.util.Scanner;

public class Statement_2011 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int d, a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            d = x.nextInt();
            if (d == 1) a++;
            if (d == 2) b++;
            if (d == 3) c++;
        }
        if (n > 5) {
            if (a != n && b != n && c != n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            if (a == n - 1 || b == n - 1 || c == n - 1 || (a == n || b == n || c == n)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
