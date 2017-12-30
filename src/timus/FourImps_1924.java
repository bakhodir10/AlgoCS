package timus;

import java.util.Scanner;

public class FourImps_1924 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int s = 0, n = x.nextInt();

        for(int i = 0; i <= n; i++){
            s += i;
        }
        if(s % 2 == 0) System.out.println("black");
        else System.out.println("grimy");
    }
}
