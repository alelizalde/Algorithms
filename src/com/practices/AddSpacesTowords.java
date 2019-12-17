package com.practices;

import java.util.*;

public class AddSpacesTowords {

    static List<String> dictionary = new LinkedList<>();
    static List<String> result = new ArrayList<>();
    static public void findWords(String s) {
        Map<Integer, String> record = new HashMap<>();
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int end = start + 1; end <= s.length(); end++) {
                if (dictionary.contains(s.substring(start, end))) {
                    q.push(end);
                    if (record.containsKey(start)) {
                        record.put(end, record.get(start) + " " + s.substring(start, end));
                    } else {
                        record.put(end, s.substring(start, end));
                    }

                    if (end == s.length())
                        result.add(record.get(end));
                }
            }
        }
    }

    public static void main(String[] args) {
        dictionary.add("cat");
        dictionary.add("sand");
        dictionary.add("cats");
        dictionary.add("and");
        dictionary.add("mice");
        findWords("catsandmice");
        System.out.println(result);
    }
}

