package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class DesignMostRecentlyUsedQueue_1756 {

    private final List<Integer> cache;

    public DesignMostRecentlyUsedQueue_1756(int n) {
        this.cache = new ArrayList<>();
        for (int i = 1; i <= n; i++) cache.add(i);
    }

    public int fetch(int k) {
        int num = cache.get(k - 1);
        cache.remove(k - 1);
        cache.add(num);
        return num;
    }
}