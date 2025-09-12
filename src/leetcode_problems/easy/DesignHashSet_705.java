package leetcode_problems.easy;

import java.util.LinkedList;
import java.util.List;

public class DesignHashSet_705 {
    private final int bucketSize = 2096;
    private final Bucket[] buckets;

    public DesignHashSet_705() {
        this.buckets = new Bucket[bucketSize];
        for(int i = 0; i < buckets.length; i ++) {
            buckets[i] = new Bucket();
        }
    }

    private int getIndex(int key) {
        return key % bucketSize;
    }

    public void add(int key) {
        int idx = getIndex(key);
        buckets[idx].add(key);
    }

    public void remove(int key) {
        int idx = getIndex(key);
        buckets[idx].remove(key);
    }

    public boolean contains(int key) {
        int idx = getIndex(key);
        return buckets[idx].contains(key);
    }

    private static class Bucket {
        private final List<Integer> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public void add(int key) {
            for(int val: bucket) {
                if(val == key) return;
            }
            bucket.add(key);
        }

        public boolean contains(int key) {
            for(int val: bucket) {
                if(val == key) return true;
            }
            return false;
        }

        public void remove(int key) {
            Integer toBeRemoved = null;
            for(int val: bucket) {
                if(val == key) toBeRemoved = val;
            }
            bucket.remove(toBeRemoved);
        }
    }

    /*
        2nd approach

    private boolean[] bucket = new boolean[100];

    public void add(int key) {
        checkSize(key);
        bucket[key] = true;
    }

    public void remove(int key) {
        if (key >= bucket.length) return;
        bucket[key] = false;
    }

    public boolean contains(int key) {
        if (key >= bucket.length) return false;
        return bucket[key];
    }

    private void checkSize(int key) {
        if (key >= bucket.length) {
            boolean[] temp = bucket;
            bucket = new boolean[key + 1];
            System.arraycopy(temp, 0, bucket, 0, temp.length);
        }
    }
     */
}
