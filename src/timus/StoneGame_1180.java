package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class StoneGame_1180 {
    public static void main(String[] args) {
        long result = 0;
        Scanner x = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        String s = x.next();
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i) - '0';
        }
        if (result % 3 == 0) {
            writer.println(2);
        } else {
            writer.println(1);
            writer.println(result % 3);
        }
        writer.flush();
    }
}
