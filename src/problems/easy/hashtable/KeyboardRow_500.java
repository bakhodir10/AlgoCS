package problems.easy.hashtable;

import java.util.*;

public class KeyboardRow_500 {
    public static String[] findWords(String words[]) {
        Map<Character, Integer> alp = makeAlphabet();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int first = alp.get(words[i].charAt(0));
            boolean check = true;
            for (int j = 1; j < words[i].length(); j++) {
                if (alp.get(words[i].charAt(j)) != first) {
                    check = false;
                    break;
                }
            }
            if (check) list.add(words[i]);
        }

        return list.toArray(new String[0]);
    }

    public static Map<Character, Integer> makeAlphabet() {
        Map<Character, Integer> map = new HashMap<>();

        map.put('Q', 3);
        map.put('q', 3);
        map.put('W', 3);
        map.put('w', 3);
        map.put('E', 3);
        map.put('e', 3);
        map.put('R', 3);
        map.put('r', 3);
        map.put('T', 3);
        map.put('t', 3);
        map.put('Y', 3);
        map.put('y', 3);
        map.put('U', 3);
        map.put('u', 3);
        map.put('I', 3);
        map.put('i', 3);
        map.put('O', 3);
        map.put('o', 3);
        map.put('P', 3);
        map.put('p', 3);

        map.put('A', 2);
        map.put('a', 2);
        map.put('S', 2);
        map.put('s', 2);
        map.put('D', 2);
        map.put('d', 2);
        map.put('F', 2);
        map.put('f', 2);
        map.put('G', 2);
        map.put('g', 2);
        map.put('H', 2);
        map.put('h', 2);
        map.put('J', 2);
        map.put('j', 2);
        map.put('K', 2);
        map.put('k', 2);
        map.put('L', 2);
        map.put('l', 2);

        map.put('Z', 1);
        map.put('z', 1);
        map.put('X', 1);
        map.put('x', 1);
        map.put('C', 1);
        map.put('c', 1);
        map.put('V', 1);
        map.put('v', 1);
        map.put('B', 1);
        map.put('b', 1);
        map.put('N', 1);
        map.put('n', 1);
        map.put('M', 1);
        map.put('m', 1);
        return map;
    }
}
