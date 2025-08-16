package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII_216 {

    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> subResult = new LinkedList<>();

    // Time complexity: O(2^9)
    // Space complexity: O(n)
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, n, k, 0);
        return result;
    }

    private void backtrack(int idx, int n, int k, int sumSoFar) {
        if(sumSoFar > n || subResult.size() > k) return;

        if(sumSoFar == n && subResult.size() == k) {
            result.add(new LinkedList<>(subResult));
            return;
        }

        for(int i = idx; i <= 9; i ++) {
            sumSoFar += i;
            subResult.add(i);

            backtrack(i + 1, n, k, sumSoFar);

            sumSoFar -= i;
            subResult.removeLast();
        }
    }

    // 2nd solution
    // Time complexity: O(2^9)
    // Space complexity: O(n)
    public List<List<Integer>> combinationSum3_2(int k, int n) {
        dfs(1, n, k, 0);
        return result;
    }

    private void dfs(int i, int n, int k, int sumSoFar) {
        if(i > 9 || subResult.size() > k || sumSoFar > n) {
            if(subResult.size() == k && sumSoFar == n) {
                result.add(new LinkedList<>(subResult));
            }
            return;
        }

        sumSoFar += i;
        subResult.add(i);
        dfs(i + 1, n, k, sumSoFar);
        sumSoFar -= i;
        subResult.removeLast();
        dfs(i + 1, n, k, sumSoFar);
    }
}
