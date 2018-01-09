package timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortingHat_1446 {
    public static void main(String[] args) {
        List<String> Slytherin = new ArrayList<>();
        List<String> Hufflepuff = new ArrayList<>();
        List<String> Gryffindor = new ArrayList<>();
        List<String> Ravenclaw = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        String s[] = new String[2 * n + 1];
        for (int i = 0; i < s.length; i++) {
            s[i] = x.nextLine();
        }
        int t = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("Slytherin")) {
                for (int j = t; j < i; j++) {
                    Slytherin.add(s[j]);
                }
                t = i + 1;
            }
            if (s[i].equals("Hufflepuff")) {
                for (int j = t; j < i; j++) {
                    Hufflepuff.add(s[j]);
                }
                t = i + 1;
            }
            if (s[i].equals("Gryffindor")) {
                for (int j = t; j < i; j++) {
                    Gryffindor.add(s[j]);
                    t = i + 1;
                }
            }
            if (s[i].equals("Ravenclaw")) {
                for (int j = t; j < i; j++) {
                    Ravenclaw.add(s[j]);
                    t = i + 1;
                }
            }
        }

        System.out.println("Slytherin:");
        for (int i = 0; i < Slytherin.size(); i++) {
            if (!(Slytherin.get(i).equals("")))
                System.out.println(Slytherin.get(i));
        }
        System.out.println();

        System.out.println("Hufflepuff:");
        for (int i = 0; i < Hufflepuff.size(); i++) {
            if (!(Hufflepuff.get(i).equals("")))
                System.out.println(Hufflepuff.get(i));
        }
        System.out.println();

        System.out.println("Gryffindor:");
        for (int i = 0; i < Gryffindor.size(); i++) {
            if (!(Gryffindor.get(i).equals("")))
                System.out.println(Gryffindor.get(i));
        }
        System.out.println();

        System.out.println("Ravenclaw:");
        for (int i = 0; i < Ravenclaw.size(); i++) {
            if (!(Ravenclaw.get(i).equals("")))
                System.out.println(Ravenclaw.get(i));
        }
        System.out.println();
    }
}
