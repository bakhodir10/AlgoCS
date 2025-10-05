package leetcode_problems.medium;

public class CompareVersionNumbers_165 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int l1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int l2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (l1 < l2) return -1;
            else if (l1 > l2) return 1;
        }
        return 0;
    }
}
