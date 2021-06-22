package leetcode_problems.easy;

public class PowerOfThree_326 {

    // approach 1
    public boolean isPowerOfThree1(int num) {
        return num > 0 && Math.log10(num) / Math.log10(3) % 1 == 0;
    }

    // approach 2
    public boolean isPowerOfThree2(int num) {
        return num > 0 && (1162261467 % num == 0);
    }
}
