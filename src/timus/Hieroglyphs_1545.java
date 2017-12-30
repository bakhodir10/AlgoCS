package timus;

import java.util.Scanner;

public class Hieroglyphs_1545 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        String s[] = new String[n];
        for (int i = 0; i < s.length; i++) {
            s[i] = x.next();
        }
        String s1 = x.next();
        char c = s1.charAt(0);
        for (int i = 0; i < s.length; i++) {
            if (s[i].charAt(0) == c) System.out.println(s[i]);
        }
    }
}
