package timus;

import java.util.Scanner;

public class Sum_1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(), s = 0;
        if (n > 0)
            for (int i = 1; i <= n; i++)    {
                s += i;
            }
        else
            for (int i = 1; i >= n; i--) {
                s += i;
            }
        System.out.println(s);
    }
}
