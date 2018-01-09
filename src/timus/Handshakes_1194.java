package timus;

import java.util.Scanner;

public class Handshakes_1194 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), k = x.nextInt();
        int l = 1, sum = 0;
        while (l != n) {
            sum += l;
            l++;
        }
        System.out.println(sum - k);
    }
}
