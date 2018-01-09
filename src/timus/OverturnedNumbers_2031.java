package timus;

import java.util.Scanner;

public class OverturnedNumbers_2031 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        if (n == 1) {
            System.out.println("01");
        } else if (n == 2) {
            System.out.println("11 01");
        } else if (n == 3) {
            System.out.println("16 06 68");
        } else if (n == 4) {
            System.out.println("16 06 68 88");
        } else {
            System.out.println("Glupenky Pierre");
        }
    }
}
