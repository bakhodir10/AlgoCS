package problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConsDuplicate_217 {

    // approach 1
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) return true;
            else s.add(nums[i]);
        }
        return false;
    }

    // approach 2
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    // approach 3
    public boolean containsDuplicate3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
