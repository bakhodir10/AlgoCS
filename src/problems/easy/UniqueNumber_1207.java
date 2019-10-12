package problems.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumber_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[2001];
        Set<Integer> occurrences = new HashSet<>();

        for (int num : arr) counts[num + 1000]++;

        for (int count : counts) {
            if (count == 0) continue;
            if (occurrences.contains(count)) return false;
            occurrences.add(count);
        }
        return true;
    }
}
