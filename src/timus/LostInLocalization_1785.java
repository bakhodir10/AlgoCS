package timus;

import java.util.Scanner;

public class LostInLocalization_1785 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int a = x.nextInt();
        if (a >= 1 && a <= 4) System.out.println("few");
        else if (a >= 5 && a <= 9) System.out.println("several");
        else if (a >= 10 && a <= 19) System.out.println("pack");
        else if (a >= 20 && a <= 49) System.out.println("lots");
        else if (a >= 50 && a <= 99) System.out.println("horde");
        else if (a >= 100 && a <= 249) System.out.println("throng");
        else if (a >= 250 && a <= 499) System.out.println("swarm");
        else if (a >= 500 && a <= 999) System.out.println("zounds");
        else if (a >= 1000) System.out.println("legion");
    }
}
