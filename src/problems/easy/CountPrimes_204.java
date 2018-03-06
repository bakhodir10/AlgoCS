package problems.easy;

public class CountPrimes_204 {
    /*
     problem was 121 is not prime !
     */
    public int countPrimes(int n) {
        if (n == 0) return 0;
        boolean b[] = new boolean[n];
        b[0] = true;
        if (n > 1) b[1] = true;
        if (n > 4) b[4] = true;
        if (n > 6) b[6] = true;

        int count = 0;
        for (int i = 8; i < n; i++) {
            if (i < n && i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) b[i] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                System.out.println(i + " " + b[i]);
                count++;
            }
        }
        return count;
    }
}
