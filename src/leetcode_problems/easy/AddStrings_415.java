package leetcode_problems.easy;


public class AddStrings_415 {
    public static String addStrings(String s1, String s2) {
        StringBuilder ans = new StringBuilder();

        if (s1 == null || s2 == null) return "";

        int r = 0;
        int k = s1.length() - 1, m = s2.length() - 1;

        while (k >= 0 || m >= 0) {
            int num1 = k >= 0 ? (s1.charAt(k) - '0') : 0;
            int num2 = m >= 0 ? (s2.charAt(m) - '0') : 0;
            int sum = num1 + num2;
            ans.insert(0, (sum + r) % 10);

            if ((sum + r) >= 10) r = 1;
            else r = 0;

            k--;
            m--;
        }

        if (r == 1) ans.insert(0, 1);

        return ans.toString().trim();
    }
}
