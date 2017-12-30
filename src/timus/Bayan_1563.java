package timus;

import java.util.Scanner;

public class Bayan_1563 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), t = 0;
        String s[] = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            s[i] = x.nextLine();
        }
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].equals(s[j])) {
                    t++;
                    s[i] = "";
                }
            }
        }
        System.out.println(t);
    }
}
