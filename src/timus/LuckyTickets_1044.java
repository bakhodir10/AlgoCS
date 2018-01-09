package timus;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class LuckyTickets_1044 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int count = 0, n = x.nextInt();
        if (n == 2) {
            System.out.println(10);
            return;
        }
        if (n == 4) {
            System.out.println(670);
            return;
        }
        if (n == 6) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= 9; k++) {
                        for (int l = 0; l <= 9; l++) {
                            for (int m = 0; m <= 9; m++) {
                                for (int o = 0; o <= 9; o++) {
                                    if (i + j + k == l + m + o) count++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
        if (n == 8) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= 9; k++) {
                        for (int l = 0; l <= 9; l++) {
                            for (int m = 0; m <= 9; m++) {
                                for (int o = 0; o <= 9; o++) {
                                    for (int p = 0; p <= 9; p++) {
                                        for (int q = 0; q <= 9; q++) {
                                            if (i + j + k + l == m + o + p + q) count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
