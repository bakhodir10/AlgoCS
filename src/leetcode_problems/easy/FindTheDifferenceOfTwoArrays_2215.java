package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays_2215 {

    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for (int num : nums1) nums1Set.add(num);
        for (int num : nums2) nums2Set.add(num);

        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for (int num : nums1Set) {
            if (!nums2Set.contains(num)) result.getFirst().add(num);
        }

        for (int num : nums2Set) {
            if (!nums1Set.contains(num)) result.get(1).add(num);
        }
        return result;
    }
}
