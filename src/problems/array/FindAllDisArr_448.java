package problems.array;

import java.util.*;

public class FindAllDisArr_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ones = new ArrayList<>();
        int k = 1;
        for (int i = 0; i < nums.length; i++) ones.add(k++);
        for (int i = 0; i < nums.length; i++) ones.set(nums[i] - 1, -1);
        int i = 0;
        while (i < ones.size()) {
            if (ones.get(i) == -1) ones.remove(i);
            else i++;
        }
        return ones;
    }
}
