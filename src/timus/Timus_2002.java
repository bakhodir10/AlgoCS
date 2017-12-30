package timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Timus_2002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> users = new HashMap<>();
        Map<String, Boolean> logging = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String line = sc.nextLine();
            String[] strs = line.split(" ");
            if (strs[0].equals("register")) {
                if (users.containsKey(strs[1])) {
                    System.out.println("fail: user already exists");
                } else {
                    users.put(strs[1], strs[2]);
                    logging.put(strs[1], false);
                    System.out.println("success: new user added");
                }
            } else if (strs[0].equals("login")) {
                if (!users.containsKey(strs[1])) {
                    System.out.println("fail: no such user");
                } else if (!users.get(strs[1]).equals(strs[2])) {
                    System.out.println("fail: incorrect password");
                } else {
                    if (logging.get(strs[1])) {
                        System.out.println("fail: already logged in");
                    } else {
                        System.out.println("success: user logged in");
                        logging.put(strs[1], true);
                    }
                }
            } else if (strs[0].equals("logout")) {
                if (users.containsKey(strs[1])) {
                    if (logging.get(strs[1])) {
                        System.out.println("success: user logged out");
                        logging.put(strs[1], false);
                    } else {
                        System.out.println("fail: already logged out");
                    }
                } else {
                    System.out.println("fail: no such user");
                }
            }
        }
    }
}
