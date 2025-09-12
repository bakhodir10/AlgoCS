package leetcode_problems.hard;

import java.util.Random;

public class DesignSkiplist_1206 {


    /*
        2nd approach
    private final int level;
    private final int[][] table;
    private final Random random;

    public DesignSkiplist_1206() {
        this.level = 100;
        int tableSize = 20001;
        this.table = new int[level][tableSize];
        this.random = new Random();
    }

    private int getRandomLevel() {
        return random.nextInt(level);
    }

    public boolean search(int target) {
        for(int i = level - 1; i >= 0; i --) {
            if(table[i][target] > 0) return true;
        }
        return false;
    }

    public void add(int num) {
        int idx = getRandomLevel();
        for(int i = 0; i <= idx; i ++) {
            table[i][num]++;
        }
    }

    public boolean erase(int num) {
        boolean found = false;
        for(int i = level - 1; i >= 0; i --) {
            if(table[i][num] > 0) {
                found = true;
                table[i][num]--;
            }
        }
        return found;
    }
     */
}
