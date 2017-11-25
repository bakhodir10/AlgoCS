package judge.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// todo not done

public class EsreveRredrO_1226 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        solve(s);
    }

    public static void solve(String s) {
        String text[];
        text = s.split(" ");
        for (int i = 0; i < text.length; i++) {
            String revers = "";
            String temp;
            for (int j = text[i].length() - 1; j >= 0;  j--) {
                    revers = revers.concat(String.valueOf(text[i].charAt(j)));
            }
            if (revers.charAt(0) == '!' || revers.charAt(0) == ',' || revers.charAt(0) == '.' || revers.charAt(0) == '?'
                    || revers.charAt(0) == ':' || revers.charAt(0) == ' ' || revers.charAt(0) == ';') {
                temp = revers.substring(1, revers.length());
                revers = temp.concat(String.valueOf(revers.charAt(0)));
            }
            if (i != text.length - 1)
            System.out.print(revers + " ");
            else System.out.print(revers);
        }
    }
}
/*
This is an example of a simple test. If you did not understand the ciphering algorithm yet, then write the letters of each word in the reverse order. By the way, "reversing" the text twice restores the original text.
 */
