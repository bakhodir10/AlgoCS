package timus;

import java.util.Scanner;

public class SMSSpam_1567 {
    public static void main(String[] args) {
        char s[] = new char[1001];
        String word = "abcdefghijklmnopqrstuvwxyz^.,! ";

        int n, i, ans = 0, j, k = 0;
        Scanner x = new Scanner(System.in);
        n = s.length;

        for (i = 0; i < n; i++) {
            for (j = 0; j < 32; j++)
                if (s[i] == word.charAt(j)) {
                    k = (j + 1) % 3;
                    if (k == 0)
                        k = 3;
                }
            ans += k;
        }
        System.out.println(ans);
    }
}
