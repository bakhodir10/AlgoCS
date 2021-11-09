package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BuildArrayStack_1441 {

    // Time complexity O(n). Memory complexity O(n)
    public List<String> buildArray(int[] target, int n) {
        int idx = 1;
        int count = 0;
        List<String> list = new ArrayList<>();
        Set<Integer> set = Arrays.stream(target).boxed().collect(Collectors.toSet());

        while (idx <= n && count < target.length) {
            list.add("Push");

            if (!set.contains(idx)) list.add("Pop");
            else count++;

            idx++;
        }
        return list;
    }
}
