package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class Park_1796 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a;
        int c[] = new int[]{10, 50, 100, 500, 1000, 5000};
        int mini = 6, k = 0;
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            a = in.nextInt();
            if (a != 0 && mini > i) {
                mini = i;
                k = c[i];
            }
            sum += (a * c[i]);
        }
        int cost = in.nextInt();
        int max = sum / cost;
        int min = (sum - k) / cost + 1;
        System.out.println(max - min + 1);
        for (int i = min; i <= max; i++) {
            System.out.print(i + " ");
        }
        out.flush();
    }
}
