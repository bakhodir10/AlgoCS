package problems.medium;

public class Single_Element_540 {
    public static int singleNonDuplicate(int nums[]) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) single ^= nums[i];
        return single;
    }
}
