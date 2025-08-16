package leetcode_problems.easy;

import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumLessThanTarget_2824 {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int countPairs1(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1, count = 0;
        for(int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if(nums.get(i) + nums.get(j) < target) count++;
            }
        }
        return count;
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(n) or O(1) based on sorting algorithm
    public int countPairs2(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1, count = 0;
        Collections.sort(nums);

        while(l < r) {
            if(nums.get(l) + nums.get(r) < target) {
                count += r - l;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
