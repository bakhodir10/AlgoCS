package skiena_book;

public class Ex3_25 {

    private boolean isWordInMagazine(String searchString, String magazine) {
        int[] counts = new int[256];
        int missing = 0;
        for (char c : searchString.toCharArray()) {
            if (counts[c] == 0) missing++;
            counts[c]++;
        }

        for (char c : magazine.toCharArray()) {
            counts[c]--;
            if (counts[c] == 0) missing--;
            if (missing == 0) return true;
        }
        return false;
    }
}
