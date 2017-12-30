package timus;

import java.util.Scanner;

public class LonesomeKnight_1197 {
    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        for (int i = 0; i < n; i++) {
            knight(x.next());
        }
    }

    public static void knight(String f) {
        int x = (f.charAt(0) - 'a') + 1;
        int y = f.charAt(1) - '0';
        int t = 0;
        if (x + 2 <= 8 && y + 1 <= 8) t++;
        if (x + 2 <= 8 && y - 1 > 0) t++;
        if (x - 2 > 0 && y - 1 > 0) t++;
        if (x - 2 > 0 && y + 1 <= 8) t++;
        if (y - 2 > 0 && x - 1 > 0) t++;
        if (y - 2 > 0 && x + 1 <= 8) t++;
        if (y + 2 <= 8 && x + 1 <= 8) t++;
        if (y + 2 <= 8 && x - 1 > 0) t++;
        System.out.println(t);
    }
}
