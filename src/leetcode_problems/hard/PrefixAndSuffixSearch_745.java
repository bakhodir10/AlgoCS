package leetcode_problems.hard;

public class PrefixAndSuffixSearch_745 {

    Trie root;
    public PrefixAndSuffixSearch_745(String[] words) {
        this.root = new Trie();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String sub = words[i].substring(j);
                String combined = sub + "#" + words[i];
                insert(combined, i);
                /*
                    Input: apple,   ap le
                    The code generates following combinations:
                    apple#apple
                    pple#apple
                    ple#apple
                    le#apple
                    e#apple
                    #apple
                */
            }
        }
    }

    private void insert(String word, int idx) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            if (c == '#') {
                if (curr.children[26] == null) curr.children[26] = new Trie();
                curr = curr.children[26];
            } else {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Trie();
                curr = curr.children[c - 'a'];
            }
            curr.weight = idx;
        }
    }

    public int f(String prefix, String suffix) {
        Trie curr = root;
        String word = suffix + "#" + prefix;
        for (char c : word.toCharArray()) {
            if (c == '#') {
                if (curr.children[26] == null) return -1;
                curr = curr.children[26];
            } else {
                if (curr.children[c - 'a'] == null) return -1;
                curr = curr.children[c - 'a'];
            }
        }
        return curr.weight;
    }
}

class Trie {
    int weight;
    Trie[] children;

    public Trie() {
        this.weight = -1;
        this.children = new Trie[27]; // from 26 letters + #
    }
    /*
        Below code works but gets Time Limit Exceeded error

//    Trie prefix;
//    Trie suffix;
//
//    public PrefixAndSuffixSearch_745(String[] words) {
//        this.prefix = new Trie();
//        this.suffix = new Trie();
//
//        for (int i = 0; i < words.length; i++) {
//            addWordPrefix(words[i], i);
//        }
//        for (int i = 0; i < words.length; i++) {
//            addWordSuffix(new StringBuilder(words[i]).reverse().toString(), i);
//        }
//    }
//
//    private void addWordPrefix(String word, int idx) {
//        Trie curr = prefix;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Trie();
//            curr = curr.children[c - 'a'];
//            curr.indices.add(idx);
//        }
//    }
//
//    private void addWordSuffix(String word, int idx) {
//        Trie curr = suffix;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Trie();
//            curr = curr.children[c - 'a'];
//            curr.indices.add(idx);
//        }
//    }
//
//    public int f(String pre, String suf) {
//        Trie currPre = prefix;
//
//        for (char c : pre.toCharArray()) {
//            if (currPre.children[c - 'a'] == null) return -1;
//            currPre = currPre.children[c - 'a'];
//        }
//
//        suf = new StringBuilder(suf).reverse().toString();
//        Trie currSuf = suffix;
//        for (char c : suf.toCharArray()) {
//            if (currSuf.children[c - 'a'] == null) return -1;
//            currSuf = currSuf.children[c - 'a'];
//        }
//
//        int maxIdx = -1;
//        for (int idx : currPre.indices) {
//            if (currSuf.indices.contains(idx)) maxIdx = Math.max(maxIdx, idx);
//        }
//
//        return maxIdx;
//    }
//
//    static class Trie {
//        Trie[] children;
//        Set<Integer> indices;
//
//        public Trie() {
//            this.children = new Trie[26];
//            this.indices = new HashSet<>();
//        }
//    }
     */
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
