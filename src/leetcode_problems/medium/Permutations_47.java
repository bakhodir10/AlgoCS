package leetcode_problems.medium;

import java.util.*;

public class Permutations_47 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new LinkedList<>();

    // Time complexity: O(n*n!)
    // Space complexity: O(n)
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);
        backtrack(nums.length, counts);
        return result;
    }

    private void backtrack(int n, Map<Integer, Integer> counts) {
        if (subResult.size() == n) {
            result.add(new LinkedList<>(subResult));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count <= 0) continue;

            subResult.add(num);
            counts.put(num, count - 1);

            backtrack(n, counts);

            subResult.removeLast();
            counts.put(num, count);
        }
    }
}
