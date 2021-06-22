package leetcode_problems.easy;

import java.util.*;

public class RelativeRanks_506 {
    public String[] findRelativeRanks(int[] nums) {
        String s[] = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int val = map.get(i);
            if (!list.isEmpty() && val == list.get(0)) {
                s[i] = "Gold Medal";
            } else if (list.size() >= 1 && val == list.get(1)) {
                s[i] = "Silver Medal";
            } else if (list.size() >= 2 && val == list.get(2)) {
                s[i] = "Bronze Medal";
            } else {
                s[i] = list.indexOf(val) + 1 + "";
            }
        }
        return s;
    }
}