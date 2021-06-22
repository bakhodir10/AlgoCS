package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FindMedianDataStream {
    /**
     * initialize your data structure here.
     */
    /**
     * initialize your data structure here.
     */
    private List<Double> list;

    public FindMedianDataStream() {
        this.list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add((double) num);
    }

    public double findMedian() {
        int size = list.size();
        if (size == 2) return (list.get(0) + list.get(1)) / 2;
        if (size % 2 == 1) return list.get(size / 2);
        else {
            double firstMiddle = list.get(size / 2 - 1);
            double secondMiddle = list.get(size / 2);
            return (firstMiddle + secondMiddle) / 2;
        }
    }

    public static void main(String[] args) {
        FindMedianDataStream m = new FindMedianDataStream();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
