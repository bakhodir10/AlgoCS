package timus;

import java.util.Scanner;

public class TeamWork_1581 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), t = 1, k = 0, l = 0;
        int a[] = new int[n + 4];
        for (int i = 0; i < n; i++) {
            a[i] = x.nextInt();
        }
        for (int i = 0; i < n + 2; i++) {

            if (a[i] == a[i + 1]) t++;
            else {
                System.out.print(t + " " + a[i] + " ");
                t = 1;
            }
        }
    }
}
