package com.practices;

import java.util.*;

import static java.lang.System.out;

public class Codec {

    private Map<String, String> urlMap;
    private char[] CharsMap = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', '0',};
    private int keyLength;

    private Codec() {
        urlMap = new HashMap<>();
        keyLength = 6;
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < keyLength; i++) {
                shortUrl.append(CharsMap[random.nextInt(62)]);
            }
            if (urlMap.containsKey(shortUrl.toString())) {
                shortUrl.setLength(0);
            } else flag = false;
        }
        urlMap.put(shortUrl.toString(), longUrl);
        return shortUrl.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //out.println(urlMap);
        return urlMap.get(shortUrl);
    }

    public static void main(String[] args){
        Codec codec = new Codec();
        String shortUrl = codec.encode("http://popcornbyte.com/test1");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test2");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test3");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test4");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test5");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test6");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test7");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test8");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));

        shortUrl = codec.encode("http://popcornbyte.com/test9");
        out.println(shortUrl);
        out.println(codec.decode(shortUrl));
    }
}