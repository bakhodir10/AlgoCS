package timus;

import java.math.BigInteger;
import java.util.Scanner;

public class DivorceoftheSeven_1243 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String s = x.next();
        BigInteger big = new BigInteger(s);
        System.out.println(big.mod(BigInteger.valueOf(7)));
    }
}
