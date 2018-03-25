package problems.math;

// Sieve of Eratosthenes algorithm

public class CountPrimes_204 {
    public static int countPrimes(int n) {
        if (n == 0) return 0;
        int count = 0;
        boolean b[] = new boolean[n + 1];
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = i * i; j < n; j += i) {
                b[j] = true;
            }
        }

        b[0] = true;
        b[1] = true;
        for (int i = 0; i < n; i++) {
            if (!b[i]) count++;
        }
        return count;
    }
}
