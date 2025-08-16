package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new LinkedList<>();

    // Time complexity: O(n!/(k-1)! * (n - k)!)
    // Space complexity: O(k)
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return result;
    }

    private void dfs(int i, int n, int k) {
        if(i > n) {
            if(subResult.size() == k) result.add(new LinkedList<>(subResult));
            return;
        }
        subResult.add(i);
        dfs(i + 1, n, k);
        subResult.removeLast();
        dfs(i + 1, n, k);
    }

    // Time complexity: O(n!/(k-1)! * (n - k)!)
    // Space complexity: O(k)
    public List<List<Integer>> combine2(int n, int k) {
        backtrack(1, n, k);
        return result;
    }

    private void backtrack(int first, int n, int k) {
        if(subResult.size() > k) return;

        if(subResult.size() == k) {
            result.add(new LinkedList<>(subResult));
            return;
        }
        for(int i = first; i <= n; i ++) {
            subResult.add(i);
            backtrack(i + 1, n, k);
            subResult.removeLast();
        }
    }
}
