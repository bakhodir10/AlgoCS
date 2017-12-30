package timus;

import java.util.Scanner;

public class Spammer_1496 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        String s[] = new String[n];
        int t = 0;
        boolean b = true;
        for (int i = 0; i < s.length; i++) {
            s[i] = x.next();
        }
        String f[] = new String[n];
        int a[] = new int[101], d = 0;
        for (int i = 0; i < s.length; i++) {
            d = 0;
            for (int j = i + 1; j < s.length; j++)
                if (s[i].equals(s[j])) {
                    f[i] = s[i];
                    s[j] = "";
                    d++;
                }
            if (d >= 1) {
                if (s[i] != "")
                    System.out.println(s[i]);
            }
        }
    }
}
