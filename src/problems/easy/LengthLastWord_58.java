package problems.easy;

public class LengthLastWord_58 {

    // version 1
    public static int lengthOfLastWord1(String s) {
        String arr[] = s.split(" ");
        if(arr.length == 0) return 0;
        return arr[arr.length - 1].length();
    }

    // version 2
    public static int lengthOfLastWord2(String s){
        int count = 0, i = 0, temp = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                if(count != 0) temp = count;
                count  = 0;
            }
            else count++;
            i++;
        }
        return  count == 0 ? temp : count;
    }

    // version 3
    public static int lengthOfLastWord3(String s){
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
