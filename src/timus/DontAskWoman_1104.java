package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DontAskWoman_1104 {
    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        int result = solve(reader.readLine());
        System.out.println( result != -1 ? result : "No solution.");

        inputStreamReader.close();
        reader.close();
    }

    public static int solve(String s){
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int number;
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') number =  s.charAt(i) - 'A' + 10;
            else if (s.charAt(i) >= '0' && s.charAt(i) >= 9) number = s.charAt(i) - '0';
            else break;
            sum += number;
            if (number > max) max = number;
        }

        if (max == 0) return 2;

        for (int i = max; i <= 36; i++) {
            if (sum % i == 0) return i + 1;
        }
        return -1;
    }
}
