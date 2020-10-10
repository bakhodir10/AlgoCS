package problems.easy;

public class ReverseStringII_541 {

    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        int i = 0;

        while (i + k <= c.length) {
            helper(c, i, i + k - 1);
            i += k * 2;
        }
        helper(c, i, c.length - 1);
        return new String(c);
    }

    private void helper(char[] c, int l, int r) {
        if (l >= r) return;
        char t = c[l];
        c[l] = c[r];
        c[r] = t;
        helper(c, l + 1, r - 1);
    }
}
