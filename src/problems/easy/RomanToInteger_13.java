package problems.easy;

public class RomanToInteger_13 {
    public static int romainToInt(String s) {
        if (s.isEmpty()) return 0;

        int res = 0;
        char last = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                last = 'I';
                res += 1;
            } else if (s.charAt(i) == 'V') {
                if (last == 'I') {
                    res += 3;
                } else res += 5;
                last = 'V';
            }
            if (s.charAt(i) == 'X') {
                if (last == 'I') {
                    res += 8;
                } else res += 10;
                last = 'X';
            }

            if (s.charAt(i) == 'L') {
                if (last == 'X') {
                    res += 30;
                } else res += 50;
                last = 'L';
            }
            if (s.charAt(i) == 'C') {
                if (last == 'X') {
                    res += 80;
                } else res += 100;
                last = 'C';
            }
            if (s.charAt(i) == 'D') {
                if (last == 'C') {
                    res += 300;
                } else res += 500;
                last = 'D';
            }
            if (s.charAt(i) == 'M') {
                if (last == 'C') {
                    res += 800;
                } else res += 1000;
                last = 'M';
            }
        }
        return res;
    }
}