package crack_code_interview.chapter1;

/*
    Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin-
    drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
 */

public class PalindromePermutation {

    // Time complexity: O(n). Space complexity: O(1)
    public static boolean palindromePermutation(String s) {

        int sum = 0;
        s = s.toLowerCase();
        int counts[] = new int[256];

        for (char c : s.toCharArray()) counts[c]++;
        for (int i : counts) sum += i % 2;

        return sum <= 1;
    }
}
