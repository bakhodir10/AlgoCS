package timus;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class HeatingMain_1457 {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        Scanner x = new Scanner(System.in);
        short n = x.nextShort();
        double s = 0;
        for (int i = 0; i < n; i++) {
            s += x.nextInt();
        }
        writer.printf("%.6f", s / n);
        writer.close();
    }
}
