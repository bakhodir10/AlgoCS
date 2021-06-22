package leetcode_problems.easy;

public class DesignHashSet_705 {

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
}
