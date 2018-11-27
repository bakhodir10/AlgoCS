package algo;

/*
    The given a set of coin values coins = {c1, c2,..., c3} and a target sum of money n, our task is to form
    the the sum n using as few coins as possible. Return min number of coin
 */

// todo not finished
public class Coins {

    public static void main(String[] args) {
        System.out.println(solve1(new int[]{1, 3, 4}, 10, Integer.MAX_VALUE));
    }

    // with greedy algorithm
    public static int solve1(int coins[], int x, int best) {
        if (x < 0) return -1;
        if (x == 0) return 0;
//        int best = Integer.MAX_VALUE;
        for (int c : coins) {
            best = Math.min(best, solve1(coins, (x - c) + 1, best));
        }
        return best;
    }
}
