package timus;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Sabotage_1290 {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        Scanner x = new Scanner(System.in);
        int a[] = new int[x.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = x.nextInt();
        }
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 0; i--) {
            writer.println(a[i]);
        }
        writer.close();
    }
}
