package leetcode_problems.easy;

public class JewelStones_771 {
    public static int numJewelsInStones(String j, String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (j.indexOf(c) >= 0) count++;
        }
        return count;
    }
}