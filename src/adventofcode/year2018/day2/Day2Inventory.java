package adventofcode.year2018.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Inventory {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/adventofcode/year2018/day2/day2.txt"));
        long countOf2 = 0, countOf3 = 0;

        while (scanner.hasNextLine()) {
            int[] counts = new int[26];
            char[] chars = scanner.nextLine().toCharArray();
            boolean found2 = false, found3 = false;

            for (char c : chars) counts[c - 'a']++;
            for (int i : counts) {
                if (i == 2) {
                    if (!found2) countOf2++;
                    found2 = true;
                }
                if (i == 3) {
                    if (!found3) countOf3++;
                    found3 = true;
                }
            }
        }
        System.out.println(countOf2 * countOf3);
    }
}
