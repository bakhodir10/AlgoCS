package problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionArray_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            boolean b = set1.contains(nums2[i]);
            if (b) set2.add(nums2[i]);
        }
        int arr[] = new int[set2.size()];
        Iterator<Integer> it = set2.iterator();
        int i = 0;
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
        return arr;
    }
}
