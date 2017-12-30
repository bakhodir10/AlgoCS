package timus;

import java.util.Scanner;

public class SandroBook_1723 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println(solve(x.next()));
    }

    public static char solve(String s){
        int a[] = new int[200];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)] ++;
        }

        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                index = i;
                max = a[i];
            }
        }
        return (char)(index);
    }
}
