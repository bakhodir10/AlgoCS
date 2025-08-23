package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subRes = new LinkedList<>();

    // Time complexity: O(n^(target/n))
    // Space complexity: O(target/n)
    public List<List<Integer>> combinationSum_1(int[] c, int target) {
        backtrack(0, c, target, 0);
        return res;
    }

    private void backtrack(int idx, int[] c, int target, int sumSoFar) {
        if(sumSoFar > target) return;

        if(sumSoFar >= target) {
            res.add(new LinkedList<>(subRes));
            return;
        }

        for(int i = idx; i < c.length; i ++) {
            subRes.add(c[i]);
            sumSoFar += c[i];

            backtrack(i, c, target, sumSoFar);

            subRes.removeLast();
            sumSoFar -= c[i];
        }
    }

    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        helper(candidates, 0, target, new LinkedList<>());
        return res;
    }

    private void helper(int[] can, int start, int target, LinkedList<Integer> sub) {
        if(target >= 0) {
            if(target == 0) {
                res.add(new ArrayList<>(sub));
            } else {
                for(int i = start; i < can.length; i++) {
                    sub.add(can[i]);
                    helper(can, i, target - can[i], sub);
                    sub.removeLast();
                }
            }
        }
    }
}
