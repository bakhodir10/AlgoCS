package timus;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class CipherGrille_1712 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String d = "";
        char c[][] = new char[4][4];
        char s[][] = new char[4][4];
        char v[][] = new char[4][4];
        for (int i = 0; i < c.length; i++) {
            d = x.next();
            c[i] = d.toCharArray();
        }
        for (int i = 0; i < s.length; i++) {
            d = x.next();
            s[i] = d.toCharArray();
        }
        // for  line 1 st;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (c[i][j] == 'X') {
                    System.out.print(s[i][j]);
                    s[i][j] = '*';
                }
            }
        }
        // for line 2 nd;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[c.length - j - 1][i] == 'X') {
                    System.out.print(s[i][j]);
                    s[i][j] = '*';
                }
            }
        }
        // for line 3 tr;
        int k = 0, l = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            l = 0;
            for (int j = c.length - 1; j >= 0; j--) {
                v[k][l++] = c[i][j];
            }
            k++;
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if (v[i][j] == 'X') {
                    System.out.print(s[i][j]);
                    s[i][j] = '*';
                }
            }
        }
        // for line 4th;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[i][j] != '*') {
                    System.out.print(s[i][j]);
                }
            }
        }
    }
}
