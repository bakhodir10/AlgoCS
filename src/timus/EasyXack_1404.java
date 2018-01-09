package timus;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EasyXack_1404 {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        Scanner x = new Scanner(System.in);
        String s = x.next();
        int a[] = new int[s.length()];
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - 97;
        }

        for (int i = 1; i < a.length; i++) {
            while (a[i] < a[i - 1]) {
                a[i] += 26;
            }
        }
        if (s.length() == 1) {
            if (a[0] < 5) {
                System.out.print((char) (26 + a[0] - 5 + 97));
            } else {
                System.out.print((char) (a[0] + 97 - 5));
            }
            return;
        } else {
            if (a[0] < 5) {
                writer.print((char) (26 + a[0] - 5 + 97));
            } else {
                writer.print((char) (a[0] + 97 - 5));
            }
            for (int i = 1; i < a.length - 1; i++) {
                writer.print((char) (a[i] - a[i - 1] + 97));
                b = a[i];
            }
            writer.print((char) (a[a.length - 1] - b + 97));
        }
        writer.close();
    }
}
