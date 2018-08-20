package crack_code_interview.chapter1;

/*
    String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
    of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
    call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
 */
public class StringRotation {

    // Time complexity: O(n). Space complexity: O(1)
    public static boolean stringRotation(String s1, String s2) {
        return s1.concat(s1).contains(s2);
    }
}
