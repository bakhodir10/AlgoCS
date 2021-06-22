package leetcode_problems.easy;

public class ImplementstrStr_28 {
    public int strStr(String haystack, String needle) {
        return haystack == null || needle == null ? -1 : haystack.indexOf(needle);
    }
}
