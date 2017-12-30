package timus;

import java.util.Scanner;

public class CodeHamming_1792 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = 7;
        int a[] = new int[11];
        for (int i = 1; i <= n; i++) a[i] = x.nextInt();
        for (int i = 1; i < 10; i++) {
            if (((a[2] + a[3] + a[4]) % 2 == a[5]) && ((a[1] + a[3] + a[4]) % 2 == a[6]) &&
                    ((a[1] + a[2] + a[4]) % 2 == a[7]))
                break;
            else {
                if (a[i] == 0) a[i] = 1;
                else a[i] = 0;
                if (a[i - 1] == 0) a[i - 1] = 1;
                else a[i - 1] = 0;
            }
        }

        for (int i = 1; i <= n; i++)
            System.out.print(a[i] + " ");
    }
}
