package codeforces;

import java.util.Scanner;

public class WayTooLong_71A {
    public static void main(String[] args) {
        Scanner x =  new Scanner(System.in);
        int n = x.nextInt();
        String s[] = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = x.next();
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(makeAbbreviation(s[i]));
        }
    }

    public static String makeAbbreviation(String text){
        return text.length() > 10 ? text.charAt(0) + "" + String.valueOf(text.length() - 2) + "" + text.charAt(text.length() - 1) : text;
    }
}
