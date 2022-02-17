package leetcode_problems.medium;

import java.util.List;

public class NestedListWeightSumII_364 {

    private int maxDepth = Integer.MIN_VALUE;
    private int sum = 0;

    // Time complexity: O(n). Space complexity: O(n)
    public int depthSumInverse(List<NestedInteger> nestedList) {
        findMaxDepth(nestedList, 1);
        calculateSum(nestedList, 1);
        return sum;
    }

    private void findMaxDepth(List<NestedInteger> nestedList, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) findMaxDepth(ni.getList(), depth + 1);
        }
    }

    private void calculateSum(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) sum += ni.getInteger() * (maxDepth - depth + 1);
            else calculateSum(ni.getList(), depth + 1);
        }
    }

    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        // public NestedInteger();

        // Constructor initializes a single integer.
        // public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
