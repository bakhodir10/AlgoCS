package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class NumOfSelfDivisiblePerms_2992 {

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    int count = 0;
    public int selfDivisiblePermutationCount(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 0, visited);
        return count;
    }

    private void backtrack(int n, int currLen, boolean[] visited) {
        if(currLen == n) {
            count++;
            return;
        }

        for(int i = 1; i <= n; i ++) {
            if(visited[i]) continue;
            if(gcd(i, currLen + 1) != 1) continue;

            visited[i] = true;
            backtrack(n, currLen + 1, visited);
            visited[i] = false;
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;  // remainder
            a = temp;
        }
        return a;
    }
}
