package timus;

import java.util.Scanner;

public class A380_1893 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String s = x.next();
        char c;
        int i = 0, h = 0;
        while (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            h = h * 10 + (s.charAt(i) - '0');
            i++;
        }
        c = s.charAt(i);
        if (h >= 1 && h <= 2) {
            if (c == 'A' || c == 'D') {
                System.out.println("window");
                return;
            } else {
                System.out.println("aisle");
                return;
            }
        }
        if (h <= 20) {
            if (c == 'A' || c == 'F') {
                System.out.println("window");
                return;
            } else {
                System.out.println("aisle");
                return;
            }
        }
        if (h <= 65) {
            if (c == 'A' || c == 'K') {
                System.out.println("window");
            } else if (c == 'C' || c == 'D' || c == 'G' || c == 'H') {
                System.out.println("aisle");
            } else {
                System.out.println("neither");
            }
        }
    }
}
