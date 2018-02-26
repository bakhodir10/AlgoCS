package problems.easy;

public class MergeSortedArray_88 {
    public void merge(int nums1[], int m, int nums2[], int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        int i = m - 1, j = n - 1, lenArr = nums1.length - 1;
        while (i != -1 && j != -1) {
            if (nums1[i] > nums2[j]) nums1[lenArr--] = nums1[i--];
            else nums1[lenArr--] = nums2[j--];
        }
        while (j >= 0) nums1[lenArr--] = nums2[j--];
    }
}