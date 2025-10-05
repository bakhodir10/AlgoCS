package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class MinPairRemovalSortArrayI_3507 {

    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int num: nums) list.add(num);

        while(!isNonDecreasing(list)) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int i = 1; i < list.size(); i++) {
                if(list.get(i) + list.get(i - 1) < min) {
                    min = list.get(i) + list.get(i - 1);
                    idx = i - 1;
                }
            }

            list.set(idx, min);
            list.remove(idx + 1);
            count++;
        }
        return count;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i - 1) > list.get(i)) return false;
        }
        return true;
    }
}
