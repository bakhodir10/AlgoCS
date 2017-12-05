package problems.easy;

// todo not done
public class RotateArray_189 {
    public static void main(String[] args) {
        rotate1(new int[]{2, 1}, 1);
    }

    public static void rotate1(int[] nums, int k){

        for (int i = nums.length - (k % nums.length); i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        for (int i = 0; i < nums.length - (k % nums.length); i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
