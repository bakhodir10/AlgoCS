package problems.easy;

public class RomanToInteger_13 {
    public static int romainToInt(String s) {
        if (s.isEmpty()) return 0;

        int res = 0;
        char last = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == 'I') {
                last = 'I';
                res += 1;
            }
            if (current == 'V') {
                if (last == 'I') res += 3;
                else res += 5;
                last = 'V';
            }
            if (current == 'X') {
                if (last == 'I') res += 8;
                else res += 10;
                last = 'X';
            }
            if (current == 'L') {
                if (last == 'X') res += 30;
                else res += 50;
                last = 'L';
            }
            if (current == 'C') {
                if (last == 'X') res += 80;
                else res += 100;
                last = 'C';
            }
            if (current == 'D') {
                if (last == 'C') res += 300;
                else res += 500;
                last = 'D';
            }
            if (current == 'M') {
                if (last == 'C') res += 800;
                else res += 1000;
                last = 'M';
            }
        }
        return res;
    }
}