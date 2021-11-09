package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignMostRecentlyUsed_1756 {

    private List<Integer> list;

    // Time complexity: O(n)
    public DesignMostRecentlyUsed_1756(int n) {
        this.list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
    }

    // Time complexity: O(1)
    public int fetch(int k) {
        int num = list.get(k - 1);
        list.remove(k - 1);
        list.add(num);
        return num;
    }
}
