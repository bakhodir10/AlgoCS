package adventofcode.year2018.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/adventofcode/year2018/day2/day2part2.txt"));
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        for (int i = 0; i < list.size(); i++) {
            String first = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                String second = list.get(j);
                String s = findCommon(first, second);
                if (!s.equals(first)) {
                    System.out.println(s);
                    break;
                }
            }
        }
    }

    private static String findCommon(String s1, String s2) {
        if (s1.length() != s2.length()) return s1;

        int i = 0, notMatch = 0, index = -1;

        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                notMatch++;
                index = i;
            }
            i++;
        }
        if (notMatch == 1) s1 = s1.substring(0, index) + s1.substring(index + 1);
        return s1;
    }
}
