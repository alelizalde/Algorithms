package com.practices;

import java.util.*;

public class FindWords {

    static List<String> dictionary = new LinkedList<>();
    static List<String> Result = new LinkedList<>();
    static public boolean findWords(String s) {
        Deque<Integer> q = new LinkedList<>();
        int[] visited = new int[s.length()];
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.poll();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dictionary.contains(s.substring(start, end))) {
                        q.push(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        dictionary.add("cat");
        dictionary.add("sand");
        dictionary.add("cats");
        dictionary.add("and");
        dictionary.add("mice");
        System.out.println(findWords("catsandmice"));
    }
}

