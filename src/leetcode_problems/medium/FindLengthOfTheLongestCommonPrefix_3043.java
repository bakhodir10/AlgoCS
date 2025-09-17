package leetcode_problems.medium;

public class FindLengthOfTheLongestCommonPrefix_3043 {

    // Time complexity: O(n + m)
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        // add all arr1 to Trie;
        for(int num: arr1) {
            Trie curr = trie;
            String numS = String.valueOf(num);

            for(char c: numS.toCharArray()) {
                Trie child = curr.children[c - '0'];
                if(child == null) curr.children[c - '0'] = new Trie();
                curr = curr.children[c - '0'];
            }
        }

        // search each number of arr2 from the Trie now
        int max = 0;
        for(int num: arr2) {
            Trie curr = trie;
            String numS = String.valueOf(num);
            int count = 0;

            for(char c: numS.toCharArray()) {
                Trie child = curr.children[c - '0'];
                if(child == null) break;
                curr = curr.children[c - '0'];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[10];
        }
    }
}
