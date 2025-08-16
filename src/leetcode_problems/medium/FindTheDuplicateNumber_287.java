package leetcode_problems.medium;

public class FindTheDuplicateNumber_287 {

    // Floyd's Tortoise and Hare algorithm
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;
        while(true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) return slow;
        }
    }

    // Using bucket sort
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int findDuplicate2(int[] nums) {
        boolean[] bucket = new boolean[100001];
        for(int num: nums) {
            if(bucket[num]) return num;
            bucket[num] = true;
        }
        return -1;
    }
}
