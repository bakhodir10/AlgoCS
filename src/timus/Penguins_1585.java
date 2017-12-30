package timus;

import java.util.Scanner;

public class Penguins_1585 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = -1, t1 = 0, t2 = 0, t3 = 0;
        String a = "Emperor Penguin";
        String b = "Macaroni Penguin";
        String c = "Little Penguin";
        String s2[] = new String[10001];
        for (int i = 0; i <= n; i++) {
            s2[i] = in.nextLine();
        }
        for (int i = 0; i <= n; i++) {
            if (s2[i].equals(a)) t1++;
            if (s2[i].equals(b)) t2++;
            if (s2[i].equals(c)) t3++;
        }
        int g = Math.max(Math.max(t1, t2), t3);
        if (g == t1) System.out.print(a);
        else if (g == t2) System.out.print(b);
        else if (g == t3) System.out.print(c);
    }
}
