package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Intervals_1330 {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + Integer.parseInt(reader.readLine());
        }
        int l = Integer.parseInt(reader.readLine());
        for (int i = 0; i < l; i++) {
            String s = reader.readLine();
            String s1[] = s.split(" ");
            int j = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);
            writer.println(func(a, j, k));
        }
        writer.flush();
        reader.close();
    }

    private static int func(int a[], int x, int y) {
        int res = 0;
        res = a[y] - a[x - 1];
        return res;
    }
}
