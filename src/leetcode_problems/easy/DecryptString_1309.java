package leetcode_problems.easy;

public class DecryptString_1309 {

    // Time complexity: O(n^2 -> StringBuilder insert() takes O(n)). Space complexity: O(n)
    public String freqAlphabets1(String s) {
        int idx = s.length() - 1;
        String alph = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder res = new StringBuilder(new String());

        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                int pos1 = s.charAt(idx - 2) - '0';
                int pos2 = s.charAt(idx - 1) - '0';

                res.insert(0, alph.charAt(pos1 * 10 + pos2 - 1));
                idx -= 3;
            } else {
                int pos = s.charAt(idx) - '0' - 1;
                res.insert(0, alph.charAt(pos));
                idx--;
            }
        }
        return res.toString();
    }

    // Time complexity: O(n). Space complexity: O(n)
    public String freqAlphabets2(String s) {
        int i = 0;
        char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder res = new StringBuilder();

        while (i < s.length()) {
            int idx = 0;
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                idx = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' - 1;
                i += 3;
            } else {
                idx = s.charAt(i) - '0' - 1;
                i++;
            }
            res.append(alph[idx]);
        }
        return res.toString();
    }
}
