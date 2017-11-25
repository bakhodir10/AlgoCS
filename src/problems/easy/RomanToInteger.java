package problems.easy;

// todo not done
public class RomanToInteger {
    public static void main(String[] args) {

    }

    public int romanToInt(String s){
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') value += 1;
            if (s.charAt(i) == 'V') value += 5;
            if (s.charAt(i) == 'X') value += 10;
            if (s.charAt(i) == 'L') value += 50;
            if (s.charAt(i) == 'C') value += 100;
            if (s.charAt(i) == 'D') value += 500;
            if (s.charAt(i) == 'M') value += 1000;
        }
        return value;
    }
}