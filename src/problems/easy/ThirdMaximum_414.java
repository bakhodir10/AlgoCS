package problems.easy;

import java.util.TreeSet;

public class ThirdMaximum_414 {
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size() > 3) set.pollFirst();
        }
        return set.size() < 3 ? set.last() : set.first();
    }
}
