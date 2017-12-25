package problems.easy;

public class RemoveElement_27 {
    public static int removeElement(int nums[], int val) {
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) if (nums[i] == val) count--;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = i;
                while (j < nums.length) {
                    if (nums[j] != val) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    j++;
                }
            }
        }
        return count;
    }
}
