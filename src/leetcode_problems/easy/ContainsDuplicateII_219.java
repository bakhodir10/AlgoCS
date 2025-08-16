package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII_219 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if(indexes.size() < 2) continue;
            for(int i = 1; i < indexes.size(); i++) {
                if(indexes.get(i) - indexes.get(i - 1) <= k) return true;
            }
        }
        return false;
    }
}
