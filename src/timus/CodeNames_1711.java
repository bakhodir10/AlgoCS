package timus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CodeNames_1711 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), a[] = new int[n];
        String s[][] = new String[n][3];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = x.next();
            }
        }
        for (int i = 0; i < s.length; i++) {
            Arrays.sort(s[i]);
        }
        List<String> list = new ArrayList<>();

        String f = s[x.nextInt() - 1][0];
        list.add(f);
        for (int i = 1; i < a.length; i++) {
            int k = x.nextInt();
            for (int j = 0; j < 3; j++) {
                if (s[k - 1][j].compareTo(f) > 0) {
                    f = s[k - 1][j];
                    list.add(f);
                    break;
                }
            }
        }
        if (list.size() != n)
            System.out.println("IMPOSSIBLE");
        else
            for (String aList : list) System.out.println(aList);

    }
}
