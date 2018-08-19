package crack_code_interview.chapter1;

public class OneAway {

    // Time complexity: O(n). Space complexity: O(1)
    public boolean oneAway(String s1, String s2) {

        int counter = 0;
        int counts[] = new int[256];

        for (char c : s1.toCharArray()) counts[c]++;
        for (char c : s2.toCharArray()) counts[c]--;
        for (int i : counts) counter += i;

        return counter <= 1;
    }
}
