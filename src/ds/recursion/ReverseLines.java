package ds.recursion;

public class ReverseLines {

    public static void reverseLines(String s[], int index) {
        // base case
        if (index == s.length) {
            return;
        } else {    // recursive case
            // this is similar to stack.push(n / 2);
            reverseLines(s, index + 1);
            // this method waits until reverseLines(s, index + 1) gets done
            // this is similar to invoke stack.pop(n);
            System.out.println(s[index]);
        }
    }

//    public static void main(String[] args) {
//        String s[] = new String[]{"Roses are red", "Violets are blue", "All my base", "Are belong to"};
//        reverseLines(s, 0);
//    }
}
