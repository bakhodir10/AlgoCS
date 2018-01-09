package timus;

import java.util.Scanner;

public class Alchemy_1573 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        long ans = 1;
        int a = x.nextInt(), b = x.nextInt(), c = x.nextInt(), n = x.nextInt();
        boolean blue = false, red = false, yellow = false;
        for (int i = 0; i < n; i++) {
            String s = x.next();
            if (s.equals("Blue") || s.equals("blue")) blue = true;
            if (s.equals("Red") || s.equals("red")) red = true;
            if (s.equals("Yellow") || s.equals("yellow")) yellow = true;
        }
        if (blue) ans *= a;
        if (red) ans *= b;
        if (yellow) ans *= c;
        System.out.println(ans);
    }
}
