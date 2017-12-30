package timus;

import java.util.Scanner;

public class WeddingDinner_2100 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        String s[] = new String[n];
        for (int i = 0; i < s.length; i++) {
            s[i] = x.next();
        }
        System.out.println(solve(s));
    }

    public static int solve(String s[]){
        int counter = 0;
        for (String word : s) {
            if (word.contains("+one")) counter += 2;
            else counter++;
        }
        counter += 2;
        if (counter == 13) counter++;
        return counter * 100;
    }
}
