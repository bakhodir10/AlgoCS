package timus;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

public class SymbolicSequence_1219 {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        char[] c = new char[30];
        Random random = new Random();
        int k = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            c[++k] = (char) i;
        }
        for (int i = 1; i <= 1000000; i++)
            writer.write(c[random.nextInt(26) + 1]);
        writer.close();
    }
}
