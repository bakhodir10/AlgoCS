package codeforces;

import java.util.Scanner;

public class Watermelon_4A {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println(isDivided(x.nextInt()) ? "YES" : "NO");
    }
    public static boolean isDivided(int n){
        if (n == 2) return false;
        return n % 2 == 0;
    }
}
