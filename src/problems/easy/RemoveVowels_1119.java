package problems.easy;

public class RemoveVowels_1119 {

    // Time complexity: O(n). Space complexity: O(1)
    public String removeVowels(String s) {
        return s
                .replace("a", "")
                .replace("e", "")
                .replace("i", "")
                .replace("o", "")
                .replace("u", "")
                .replace("e", "");
    }
}
