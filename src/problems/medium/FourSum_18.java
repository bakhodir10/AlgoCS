package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// todo not done
public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    int sum = target - nums[i] + nums[j];
                    int l = j + 1;
                    int r = nums.length - 1;
                    while (l < r) {
                        if (nums[l] + nums[r] == sum) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            l++;
                            r--;
                        } else if (nums[l] + nums[r] < sum) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
