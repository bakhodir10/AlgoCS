package skiena_book;

import java.util.HashMap;
import java.util.Map;

public class Ex3_11_a {

    private Map<String, Integer> map;

    public Ex3_11_a(int[] nums) {
        this.map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int theSmallest = nums[i];
            for (int j = i; j < nums.length; j++) {
                theSmallest = Math.min(theSmallest, nums[j]);
                map.put(i + "," + j, theSmallest);
            }
        }
    }

    public int findSmallestInRange(int i, int j) {
        return this.map.get(i + "," + j);
    }
}
