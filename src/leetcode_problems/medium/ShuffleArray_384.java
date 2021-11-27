package leetcode_problems.medium;

import java.util.Random;

public class ShuffleArray_384 {

    private int[] array;
    private final int[] original;
    private final Random rand;

    public ShuffleArray_384(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
        this.rand = new Random();
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public int[] reset() {
        array = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randRange(i, array.length));
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
