package problems.easy;

public class CheckIfTwoStringArrays_1662 {

    // Time complexity: O(n). Space complexity: O(1)
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String word : word1) sb1.append(word);
        for (String word : word2) sb2.append(word);

        return sb1.toString().equals(sb2.toString());
    }
}
