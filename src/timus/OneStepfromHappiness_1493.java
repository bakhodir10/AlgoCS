package timus;

import java.util.Scanner;

public class OneStepfromHappiness_1493 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int l = n;
        int t1 = 0, t2 = 0, i = 1;
        n++;
        while (i <= 3) {
            t1 += n % 10;
            n /= 10;
            i++;
        }
        while (i > 3 && i <= 6) {
            t2 += n % 10;
            n /= 10;
            i++;
        }
        if (t1 == t2) {
            System.out.println("Yes");
            return;
        } else {
            t1 = 0;
            t2 = 0;
            i = 1;
            l--;
            while (i <= 3) {
                t1 += l % 10;
                l /= 10;
                i++;
            }
            while (i > 3 && i <= 6) {
                t2 += l % 10;
                l /= 10;
                i++;
            }
        }
        if (t1 == t2) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
}
