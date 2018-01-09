package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class SashaGrandmaster_2010 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int a = x.nextInt(), b = x.nextInt(), c = x.nextInt();
        writer.println("King: " + King(a, b, c));
        writer.println("Knight: " + Knight(a, b, c));
        writer.println("Bishop: " + Bishop(a, b, c));
        writer.println("Rook: " + Rook(a, b, c));
        writer.println("Queen: " + Queen(a, b, c));
        writer.flush();
    }

    private static int King(int z, int x, int y) {
        int s = 0;
        if (x + 1 <= z) s++;
        if (x - 1 >= 1) s++;
        if (y + 1 <= z) s++;
        if (y - 1 >= 1) s++;
        if (x + 1 <= z && y + 1 <= z) s++;
        if (x + 1 <= z && y - 1 >= 1) s++;
        if (x - 1 >= 1 && y - 1 >= 1) s++;
        if (x - 1 >= 1 && y + 1 <= z) s++;
        return s;
    }

    private static int Knight(int z, int x, int y) {
        int s = 0;
        if (x + 2 <= z && y + 1 <= z) s++;
        if (x + 2 <= z && y - 1 >= 1) s++;
        if (x + 1 <= z && y - 2 >= 1) s++;
        if (x - 1 >= 1 && y - 2 >= 1) s++;
        if (x - 2 >= 1 && y - 1 >= 1) s++;
        if (x - 2 >= 1 && y + 1 <= z) s++;
        if (x - 1 >= 1 && y + 2 <= z) s++;
        if (x + 1 <= z && y + 2 <= z) s++;
        return s;
    }

    private static int Bishop(int z, int x, int y) {
        return Math.min(z - x, z - y) + Math.min(z - x, y - 1) + Math.min(z - y, x - 1) + Math.min(x - 1, y - 1);
    }

    private static int Rook(int z, int x, int y) {
        return 2 * z - 2;
    }

    private static int Queen(int z, int x, int y) {
        int s;
        int res = Math.min(z - x, z - y) + Math.min(z - x, y - 1) + Math.min(z - y, x - 1) + Math.min(x - 1, y - 1);
        s = 2 * z - 2;
        return s + res;
    }
}
