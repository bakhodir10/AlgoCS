package problems.easy;

public class NThTribonacci_1137 {

    int[] memo = new int[38];

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return memo[n];
    }
}