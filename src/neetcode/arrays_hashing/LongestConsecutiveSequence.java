package neetcode.arrays_hashing;

import java.util.*;

public class LongestConsecutiveSequence {

    // Brute force solution
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int longestConsecutive1(int[] nums) {
        if(nums.length < 2) return nums.length;

        int max = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++ ) {
            int count = 1;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j - 1] == nums[j]) continue;
                else if(nums[j - 1] + 1 == nums[j]) count++;
                else break;
            }
            max = Math.max(max, count);
            System.out.println(count);
        }
        return max;
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public int longestConsecutive2(int[] nums) {
        if(nums.length < 2) return nums.length;

        int max = 0, i = 0, j = 1;
        Arrays.sort(nums);
        while(j < nums.length) {
            int count = 1;
            while(nums[j - 1] == nums[j] || nums[j - 1] + 1 == nums[j]) {
                if(nums[j - 1] == nums[j]) j++;
                else if(nums[j - 1] + 1 == nums[j]) count++;
            }
            i = j;
            j++;
            max = Math.max(max, count);
        }
        return max;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int longestConsecutive3(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        Map<Integer, List<Integer>> sequences = new HashMap<>();

        for(int num: nums) uniques.add(num);

        for (int num : nums) {
            if (!uniques.contains(num - 1)) {
                List<Integer> sequence = new ArrayList<>();
                int val = num + 1;
                sequence.add(num);
                while (uniques.contains(val)) {
                    sequence.add(val);
                    val += 1;
                }
                sequences.put(num, sequence);
            }
        }
        int max = 0;
        for(List<Integer> sequence: sequences.values()) max = Math.max(max, sequence.size());
        return max;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int longestConsecutive4(int[] nums) {
        int max = 0;
        Set<Integer> uniques = new HashSet<>();

        for(int num: nums) uniques.add(num);

        for (int num : uniques) {
            if(uniques.contains(num - 1)) continue;
            else {
                int len = 1;
                while (uniques.contains(num + len)) {
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
