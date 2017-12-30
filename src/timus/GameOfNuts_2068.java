package timus;

import java.util.Scanner;

public class GameOfNuts_2068 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = x.nextInt();
        }
        System.out.println(solve(a));
    }

    public static String solve(int a[]){
        int i = 0, res = 0;
        while (i < a.length){
            res += a[i] / 2;
            i++;
        }
        return res % 2 != 0 ? "Daenerys" : "Stannis";
    }
}
