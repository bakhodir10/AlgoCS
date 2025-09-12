package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence_334 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean increasingTriplet(int[] nums) {
        List<Integer> list = new ArrayList<>(3);
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > list.getLast()) {
                list.add(nums[i]);
            } else {
                int j = 0;
                while(j < list.size() && nums[i] > list.get(j)) j++;
                list.set(j, nums[i]);
            }
            if(list.size() >= 3) return true;
        }
        return false;
    }
}
