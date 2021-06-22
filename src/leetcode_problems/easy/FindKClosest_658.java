package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FindKClosest_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                l = mid;
                break;
            } else if (arr[mid] > x) r = mid - 1;
            else l = mid + 1;
        }

        int left = l - 1;
        int right = l;

        while (k != 0) {
            if (left < 0) right++;
            else if (right >= arr.length) left--;
            else {
                int val1 = Math.abs(x - arr[left]);
                int val2 = Math.abs(x - arr[right]);
                if (val1 > val2) right++;
                else left--;
            }
            k--;
        }
        for (int i = left + 1; i < right; i++) ans.add(arr[i]);
        return ans;
    }
}
