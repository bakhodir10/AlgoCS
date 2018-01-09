package timus;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class AntiCAPS_1601 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Byte b = 1;
        int c;
        while ((c = System.in.read()) != -1) {
            char ch = (char) c;
            if (b == 1) {
                if (ch >= 'a' && ch <= 'z') ch = ((char) ((int) ch - 32));
                if (ch >= 'A' && ch <= 'Z') b = 0;
            } else {
                if (ch >= 'A' && ch <= 'Z') ch = (char) ((int) ch + 32);
            }
            if (ch == '.' || ch == '!' || ch == '?') b = 1;
            out.print(ch);
        }
        out.flush();
    }
}
