package leetcode_problems.medium;

import java.util.*;

public class RandomPickIndex_398 {

    // Using Reservoir algorithm each element has a probability of being picked i/n times.
    // Reservoir algorithm is when the input is large, streams or size is unknown

    private final int[] nums;
    private final Random random;

    // Time complexity: O(1)
    // Space complexity: O(1)
    public RandomPickIndex_398(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int pick(int target) {
        int res = -1, count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
                if(random.nextInt(count) == 0)   res = i;
            }
        }
        return res;
    }

/*
 Using memoization. This approach is good when the size is small or definite.
    private final Map<Integer, List<Integer>> map;

    public RandomPickIndex_398(int[] nums) {
        this.map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            List<Integer> indexes = map.getOrDefault(nums[i], new ArrayList<>());
            indexes.add(i);
            map.put(nums[i], indexes);
        }
    }

    public int pick(int target) {
        List<Integer> indexes = map.get(target);
        int index = (int) (Math.random() * indexes.size());
        new Random().nextInt(indexes.size());
        return indexes.get(index);
    }
*/
}
