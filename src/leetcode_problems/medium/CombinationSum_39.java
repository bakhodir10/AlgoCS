package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
