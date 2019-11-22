package problems.medium;

import java.util.List;

public class ReplaceWords_648 {

    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder out = new StringBuilder();
        String[] sentenceWords = sentence.split(" ");

        for (String sentenceWord : sentenceWords) {
            int minLen = Integer.MAX_VALUE;
            String minLenWord = sentenceWord;

            for (String dictWord : dict) {
                if (sentenceWord.startsWith(dictWord) && dictWord.length() < minLen) {
                    minLen = dictWord.length();
                    minLenWord = dictWord;
                }
            }
            out.append(minLenWord).append(" ");
        }

        return out.toString().trim();
    }
}