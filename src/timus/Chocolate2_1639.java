package timus;

import java.util.Scanner;

public class Chocolate2_1639 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), m = x.nextInt(), s1 = 0, s2 = 0, i = 0;
        while (i == 0) {
            if (n % 2 == 0 || m % 2 == 0) {
                if (n % 2 == 0 && m % 2 == 0) {
                    if (n > m) n = n / 2;
                    else m = m / 2;
                } else if (n % 2 == 0) n = n / 2;
                else m = m / 2;
                s1 += n * m;
            } else {
                s1 += 1;
                s2 += n * m - 1;
                n = 0;
                m = 0;
                i = 1;
            }

            if (n % 2 == 0 || m % 2 == 0) {
                if (n % 2 == 0 && m % 2 == 0) {
                    if (n > m) n = n / 2;
                    else m = m / 2;
                } else if (n % 2 == 0) n = n / 2;
                else m = m / 2;
                s2 += n * m;
            } else {
                s2 += 1;
                s1 += n * m - 1;
                n = 0;
                m = 0;
                i = 1;
            }

        }
        if (s1 >= s2) System.out.println("[:=[first]");
        else System.out.println("[second]=:]");
    }
}
