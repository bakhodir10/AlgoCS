package timus;

import java.util.Scanner;

public class BicycleCodes_1877 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        if(x.nextInt() % 2 == 0 || x.nextInt() % 2 != 0) System.out.println("yes");
        else System.out.println("no");
    }
}
