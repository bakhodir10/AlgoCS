package interviews;

// todo not done
public class NumSumsInStr {
    public static void main(String[] args) {
        int as = '9' - '2';
//        System.out.println(as);
//        System.out.println(sums("1a2b3c"));
//        System.out.println(sums("123"));
        System.out.println(sums("235"));
    }

    public static int sums(String s) {
        int sum = 0;
        int currentNum = 0;
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                currentNum = (c - '0') + (int) Math.pow(10, i) + currentNum;
                System.out.println(c);
                i++;
            } else {
                sum += currentNum;
                i = 0;
                currentNum = 0;
            }
        }
        sum += currentNum;
        return sum;
    }
}
