package problems.math;

public class AddStrings_415 {
    public static String addStrings(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int remainder = 0;
        StringBuilder sb;

        if (s1.length() < s2.length()) {
            sb = new StringBuilder(s1);
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                sb.insert(0, '0');
            }
            s1 = sb.toString();
        } else {
            sb = new StringBuilder(s2);
            for (int i = 0; i < s1.length() - s2.length(); i++) {
                sb.insert(0, '0');
            }
            s2 = sb.toString();
        }

        int len = s1.length();
        for (int i = len - 1; i >= 0; i--) {
            int e1 = (int) s1.charAt(i) - '0';
            int e2 = (int) s2.charAt(i) - '0';
            int val = e1 + e2 + remainder;
            res.insert(0, val % 10);
            remainder = val / 10;
        }
        if (remainder == 1) res.insert(0, "1");
        return res.toString();
    }
}
