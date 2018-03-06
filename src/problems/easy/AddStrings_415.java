package problems.easy;

public class AddStrings_415 {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "99"));
    }

    public static String addStrings(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int len = 0;
        int remainder = 0;
        boolean first;
        boolean second;
        if (s1.length() > s2.length()) {
            len = s1.length();
            
        } else {
            len = s2.length();
        }

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
