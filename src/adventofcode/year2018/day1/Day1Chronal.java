package adventofcode.year2018.day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day1Chronal {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/adventofcode/year2018/day1.txt"));
        long sum = 0;

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            sum += Long.parseLong(s);
        }
        System.out.println(sum);
        scanner.close();
    }
}
