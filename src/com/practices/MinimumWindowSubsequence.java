package com.practices;

public class MinimumWindowSubsequence {
    static String find(String string, String letters) {
        if (letters.length() == 0) return "letter is empty";

        int j = 0, end, start;

        for (start = 0; start < string.length(); start++) {
            if (string.charAt(start) == letters.charAt(j)) {
                j++;
            }
            if (j > letters.length()) break;
        }

        if (j < letters.length()) return "not found";

        end = start;
        j--;

        for (start = end - 1; start >= 0; start--) {
            if (string.charAt(start) == letters.charAt(j)) {
                j--;
            }
            if (j < 0) break;
        }

        return string.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(find("XAYMBAZBDCE", "ABE"));
        System.out.println(find("XAYMAZDCE", "ABE"));
        System.out.println(find("ABXAYMAZDCE", "ABE"));
        System.out.println(find("ABXAYMAZDCE", "AFBE"));
        System.out.println(find("ABXAYBMAFZBDCE", "AFBE"));
        System.out.println(find("", "AFBE"));
        System.out.println(find("ABXAYBMAFZBDCE", ""));
    }
}
