package leetcode_problems.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap_706 {

    private static class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class Bucket {
        private final List<Pair> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public void put(int key, int val) {
            for(Pair p: bucket) {
                if(p.key == key) {
                    p.val = val;
                    return;
                }
            }
            bucket.addLast(new Pair(key, val));
        }

        public int get(int key) {
            for(Pair p: bucket) {
                if(p.key == key) {
                    return p.val;
                }
            }
            return -1;
        }

        public void remove(int key) {
            Pair toBeDeleted = null;
            for(Pair p: bucket) {
                if(p.key == key) {
                    toBeDeleted = p;
                    break;
                }
            }
            if(toBeDeleted != null) bucket.remove(toBeDeleted);
        }
    }

    private final Bucket[] table;
    private final int bucketSize = 2069;

    public DesignHashMap_706() {
        this.table = new Bucket[bucketSize];
        for(int i = 0; i < table.length; i ++) {
            table[i] = new Bucket();
        }
    }

    private int getIndex(int key) {
        return key % bucketSize;
    }

    public void put(int key, int val) {
        int idx = getIndex(key);
        table[idx].put(key, val);
    }

    public int get(int key) {
        int idx = getIndex(key);
        return table[idx].get(key);
    }

    public void remove(int key) {
        int idx = getIndex(key);
        table[idx].remove(key);
    }

/*
    2nd approach.

    int[] cache;
    int size = 0;

    public DesignHashMap_706() {
        this.cache = new int[1000001];
        Arrays.fill(cache, -1);
    }

    public void put(int key, int value) {
        cache[key] = value;
    }

    public int get(int key) {
        if(key >= cache.length) return -1;
        return cache[key];
    }

    public void remove(int key) {
        cache[key] = -1;
    }
*/
}
