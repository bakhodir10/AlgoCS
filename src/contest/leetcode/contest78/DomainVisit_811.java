package contest.leetcode.contest78;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DomainVisit_811 {
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String s[] = cpdomains[i].split(" ");
            int count = Integer.valueOf(s[0]);
            String domain = s[1];

            while (!domain.isEmpty()) {
                boolean ex = map.containsKey(domain);
                if (!ex) map.put(domain, count);
                else {
                    int cc = count + map.get(domain);
                    map.put(domain, cc);
                }
                if (!domain.contains(".")) domain = "";
                else domain = domain.substring(domain.indexOf(".") + 1);
            }
        }
        for (Map.Entry<String, Integer> m : map.entrySet())
            res.add(m.getValue() + " " + m.getKey());
        return res;
    }
}
