package judge.hackerrank;

public class SparseArray {
    public static int[] sparseArray(String words[], String query[]){
        int count[] = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int counter = 0;
            for (int j = 0; j < words.length; j++) {
                if (query[i].equals(words[j])) counter ++;
            }
            count[i] = counter;
        }
        return count;
    }
}
