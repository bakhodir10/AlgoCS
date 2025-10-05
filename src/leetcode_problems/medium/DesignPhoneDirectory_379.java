package leetcode_problems.medium;

import java.util.*;

public class DesignPhoneDirectory_379 {

    private final Set<Integer> used;
    private final List<Integer> free;

    public DesignPhoneDirectory_379(int maxNumbers) {
        this.used = new HashSet<>(maxNumbers);
        this.free = new LinkedList<>();
        for(int i = 0; i < maxNumbers; i++) free.add(i);
    }

    public int get() {
        if(free.isEmpty()) return -1;
        int available = free.removeFirst();
        used.add(available);
        return available;
    }

    public boolean check(int number) {
        return !used.contains(number);
    }

    public void release(int number) {
        if(!used.contains(number)) return;

        free.addLast(number);
        used.remove(number);
    }
}
