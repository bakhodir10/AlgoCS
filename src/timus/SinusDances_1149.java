package timus;

import java.util.Scanner;

public class SinusDances_1149 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println(solve(x.nextInt()));
    }

    public static String solve(int n){
        String s = "";
        String ab[] = new String [n];
        for (int i = 1; i <= n; i++) {
             s = s.concat("sin(" + i);
            if (i % 2 != 0) s = s.concat("-");
            else s = s.concat("+");
            ab[i - 1] = s.substring(0, s.length() - 1);
            for (int j = 0; j < i; j++) {
                ab[i - 1] = ab[i - 1].concat(")");
            }
        }

        String newWord = "";
        for (int i = 0; i < n - 1; i++) {
            newWord = newWord.concat("(");
        }
        for (int i = 0; i < ab.length; i++) {
            newWord = newWord.concat(ab[i]);
            newWord = newWord.concat("+");
            newWord = newWord.concat(String.valueOf(n - i));
            newWord = newWord.concat(")");
        }
        newWord = newWord.substring(0, newWord.length() -1);
        return newWord;
    }
}