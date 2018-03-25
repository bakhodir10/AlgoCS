package problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleArray_384 {

    private int nums[];
    private int temp[];

    public ShuffleArray_384(int[] nums) {
        this.nums = nums;
        this.temp = nums;
    }

    public int[] reset() {
        return temp;
    }
    
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) list.add(i);
        Collections.shuffle(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
