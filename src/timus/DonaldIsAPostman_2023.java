package timus;

import java.util.Scanner;

public class DonaldIsAPostman_2023 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int old = 1, count = 0, d = 0;
        String s1[] = {"Alice", "Ariel", "Aurora", "Phil", "Peter", "Olaf", "Phoebus", "Ralph", "Robin",
                "Bambi", "Belle", "Bolt", "Mulan", "Mowgli", "Mickey", "Silver", "Simba", "Stitch",
                "Dumbo", "Genie", "Jiminy", "Kuzko", "Kida", "Kenai", "Tarzan", "Tiana", "Winnie"
        };
        for (int i = 0; i < n; i++) {
            String a = x.next();
            for (int j = 0; j < s1.length; j++) {
                if (a.equals(s1[j])) {
                    d = Math.abs(j / 9 + 1 - old);
                    if (j / 9 + 1 != old) count += d;
                    old = j / 9 + 1;
                }
            }
        }
        System.out.println(count);
    }
}
