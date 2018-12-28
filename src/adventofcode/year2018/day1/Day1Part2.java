package adventofcode.year2018.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day1Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        long sum = 0;
        boolean found = false;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        Scanner scanner = new Scanner(new File("src/adventofcode/year2018/day1part2.txt"));

        while (!found) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                long val = Long.parseLong(s);
                sum += val;
                if (set.contains(sum)) {
                    found = true;
                    break;
                }
                set.add(sum);
            }
            if (!found) scanner = new Scanner(new File("src/adventofcode/year2018/day1part2.txt"));
        }
        System.out.println(sum);
    }
}
