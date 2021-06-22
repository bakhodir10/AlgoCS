package leetcode_problems.easy;

public class FirstBadVer_278 {
    public int firstBadVersion(int n) {
        int from = 1, to = n;
        while (from < to) {
            int middle = from + (to - from) / 2;
            if (isBadVersion(middle)) {
                to = middle;
            } else {
                from = middle + 1;
            }
        }
        return from;
    }

    private boolean isBadVersion(int version) {
        return version == 6;
    }
}
