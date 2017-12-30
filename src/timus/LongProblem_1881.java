package timus;

import java.util.Scanner;

public class LongProblem_1881 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0, b = 0, c = 0, size = 0, list = 1, row = 1;
        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = in.next();
            size += s.length();
            if (size == w) {
                row++;
                size = 0;
            } else if (size > w) {
                row++;
                size = s.length() + 1;
            } else
                size++;
        }
        if (size == 0) row--;
        System.out.println((int) Math.ceil(row * 1. / h));
    }
}
