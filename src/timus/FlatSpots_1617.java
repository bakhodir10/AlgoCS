package timus;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FlatSpots_1617 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int n = x.nextInt(), c;
        int a[] = new int[701];
        for (int i = 0; i < n; i++) {
            c = x.nextInt();
            a[c]++;
        }
        int s = 0;
        for (int i = 600; i < a.length; i++) {
            s += a[i] / 4;
        }
        writer.print(s);
        writer.close();
    }
}
