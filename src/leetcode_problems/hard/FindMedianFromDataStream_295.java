package leetcode_problems.hard;

import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 {

    // Space complexity: O(n)
    PriorityQueue<Integer> lowers; // should return the greatest element in the queue
    PriorityQueue<Integer> highers; // should return the smallest element in the queue
    public FindMedianFromDataStream_295() {
        this.lowers = new PriorityQueue<Integer>((e1, e2) -> e2 - e1);
        this.highers = new PriorityQueue<Integer>((e1, e2) -> e1 - e2);
    }

    // Time complexity: O(log(n))
    // Space complexity: O(1)
    public void addNum(int num) {
        lowers.offer(num);
        highers.offer(lowers.poll());

        if(lowers.size() < highers.size()) lowers.offer(highers.poll());
    }

    // Time complexity: O(1)
    // Space complexity: O(1)
    public double findMedian() {
        return lowers.size() == highers.size()
                ? lowers.peek()
                : (double)(lowers.peek() + highers.peek()) / 2;
    }

//    private final List<Integer> nums;
//
//    public FindMedianFromDataStream_295() {
//        this.nums = new ArrayList<>();
//    }

    // Time complexity: O(log(n) + n) ~= O(n)
    // Space complexity: O(1)
//    public void addNum(int num) {
//        int idx = Collections.binarySearch(nums, num);
//        if (idx < 0) idx = (-idx) - 1;
//        nums.add(idx, num);
//    }
//
//    // Time complexity: O(1)
//    // Space complexity: O(1)
//    public double findMedian() {
//        int size = nums.size();
//        int oddMiddle = nums.get(size / 2);
//        return size % 2 == 1 ? oddMiddle : (double) (nums.get(size / 2 - 1) + oddMiddle) / 2;
//    }
}
