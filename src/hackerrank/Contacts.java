package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Contacts {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> wordsWithCount = new HashMap<>();
        br.readLine();

        while (br.readLine() != null) {
            String[] data = br.readLine().split(" ");
            String queryType = data[0];
            String word = data[1];
            if (queryType.equals("add")) {
                for (int j = 1; j <= word.length(); j++) {
                    String sub = word.substring(0, j);
                    int count = 0;
                    if (wordsWithCount.containsKey(sub)) count = wordsWithCount.get(sub);
                    wordsWithCount.put(sub, ++count);
                }
            } else {
                if (wordsWithCount.containsKey(word)) {
                    System.out.println(wordsWithCount.get(word));
                } else {
                    System.out.println(0);
                }
            }
        }
        br.close();
    }
}