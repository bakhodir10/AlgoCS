package problems.easy;

public class PeakIndexMountainArray_852 {

    // Time complexity: O(n). Space complexity: O(1)
    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] > arr[i]) return i - 1;
        }
        return -1;
    }
}
