package problems.easy;

public class SplitString_1221 {
    public int balancedStringSplit(String s) {
        int l = 0, r = 0, count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') l++;
            if (c == 'R') r++;
            if (l == r) count++;
        }
        return count;
    }
}
