package timus;

import java.util.Scanner;

public class CentipedesMorning_1876 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int a = x.nextInt();
        int b = x.nextInt();
        if (39 + 2 * a > 40 + 2 * b) {
            System.out.println(2 * a + 39);
        } else {
            System.out.println(2 * b + 40);
        }
    }
}
