package ds.dp;

public class Fibonacci {

    public static int fib(int n) {
        int memo[] = new int[n + 1];
        return fibHelper(n, memo);
    }

    private static int fibHelper(int n, int memo[]) {
        if (memo[n] != 0) return memo[n];
        int f;
        if (n <= 2) f = 1;
        else f = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        memo[n] = f;
        return f;
    }

    public static int lcs(int[] x, int[] y) {

        int n = x.length, m = y.length;
        int memo[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) memo[i][j] = 0;
                else if (x[i - 1] == y[j - 1]) memo[i][j] = memo[i - 1][j - 1] + 1;
                else memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m][n];
    }
}
