package skiena_book;

public class Ex3_4 {

    private int[] bucket;

    public Ex3_4(int[] nums) {
        int theBiggest = nums[0];
        for (int num : nums) theBiggest = Math.max(theBiggest, num);
        bucket = new int[theBiggest];
        for (int num : nums) bucket[num]++;
    }

    public boolean search(int num) {
        return bucket[num] != 0;
    }

    public void insertion(int num) {
        bucket[num]++;
    }

    public boolean delete(int num) {
        if (bucket[num] == 0) return false;
        else {
            bucket[num]--;
            return true;
        }
    }
}
