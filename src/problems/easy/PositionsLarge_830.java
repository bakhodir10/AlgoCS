package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsLarge_830 {

    public static List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> ans = new ArrayList<>();
        if (s.isEmpty()) return ans;
        int index = 1, start = 0;
        char prev = s.charAt(0);
        int count = 1;

        while (index < s.length()) {
            if (s.charAt(index) == prev) count++;
            else {
                if (count >= 3) ans.add(Arrays.asList(start, index - 1));
                start = index;
                count = 1;
                prev = s.charAt(index);
            }
            index++;
        }
        if (count >= 3) ans.add(Arrays.asList(start, index - 1));
        return ans;
    }
}
