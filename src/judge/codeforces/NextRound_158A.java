package judge.codeforces;

import java.util.Scanner;

public class NextRound_158A {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt(), k = x.nextInt(), a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = x.nextInt();
        }

        System.out.println(countAdvanced(k, a));
    }

    public static int countAdvanced(int k, int a[]){
        int count = 0;

        for (int i = k; i < a.length; i++) {
            if (a[i] > k) count ++;
            else break;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (a[i] > k) count ++;
        }
        return count;
    }
}
