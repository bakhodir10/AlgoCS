package problems.medium;

import java.util.ArrayList;
import java.util.List;


public class ProductLastKNums_1352 {

    private List<Integer> nums = new ArrayList<>(){{ add(1); }};

    // Time complexity: O(1). Space complexity: O(n)
    public void add(int num) {
        if (num > 0)  nums.add(nums.get(nums.size() - 1) * num);
        else nums = new ArrayList<>(){{ add(1); }};
    }

    // Time complexity: O(1). Space complexity: O(n)
    public int getProduct(int k) {
        return k < nums.size() ? nums.get(nums.size() - 1) / nums.get(nums.size() - 1 - k ) : 0;
    }
}
