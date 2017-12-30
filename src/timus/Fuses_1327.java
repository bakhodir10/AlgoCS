package timus;

import java.util.Scanner;

public class Fuses_1327 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int a = x.nextInt(), b = x.nextInt();
        int s = 0;
        for (int i = a; i <= b; i++) {
            if (i % 2 == 1) s++;
        }
        System.out.println(s);
    }
}
