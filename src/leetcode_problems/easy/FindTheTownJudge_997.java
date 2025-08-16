package leetcode_problems.easy;

public class FindTheTownJudge_997 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int findJudge(int n, int[][] trust) {
        if(n == 1) return 1;
        int []beingTrusted = new int[1001];
        boolean []personTrusts = new boolean[1001];

        for (int[] ints : trust) {
            personTrusts[ints[0]] = true;
            beingTrusted[ints[1]]++;
        }
        for(int i = 0; i < 1001; i++) {
            if(beingTrusted[i] == n - 1 && !personTrusts[i]) return i;
        }
        return -1;
    }
}
