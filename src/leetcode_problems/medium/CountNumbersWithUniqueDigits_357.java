package leetcode_problems.medium;

public class CountNumbersWithUniqueDigits_357 {

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    int count = 0;
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;

        backtrack(n, 0, new boolean[10]);
        return count + 1; // + 1 for 0
    }

    private void backtrack(int n, int currLength, boolean[] used) {
        if(currLength == n) return;

        for(char i = 0; i <= 9; i ++) {
            if(currLength == 0 && i == 0) continue; // skip leading 0 such as 00
            if(used[i]) continue;

            count++;
            used[i] = true;
            backtrack(n, currLength + 1, used);
            used[i] = false;
        }
    }
}
