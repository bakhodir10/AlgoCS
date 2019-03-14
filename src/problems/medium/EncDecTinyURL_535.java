package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class EncDecTinyURL_535 {

    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String DICT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 62 chars
    private static final Map<String, String> longTiny = new HashMap<>();
    private static final Map<String, String> tinyLong = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longTiny.containsKey(longUrl)) {
            return BASE_URL + longTiny.get(longUrl);
        }
        String tinyUrl;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int rand = (int) (Math.random() * DICT.length());
                sb.append(DICT.charAt(rand));
            }
            tinyUrl = sb.toString();
        } while (tinyLong.containsKey(tinyUrl));

        tinyLong.put(tinyUrl, longUrl);
        longTiny.put(longUrl, tinyUrl);
        return BASE_URL + tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyLong.get(shortUrl.substring(BASE_URL.length()));
    }
}
