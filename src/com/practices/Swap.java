package com.practices;

public class Swap {
    static private char[] swap (String text, int current, int pointer) {
        char[] newText = text.toCharArray();
        char tmp = newText[current];
        newText[current] = newText[pointer];
        newText[pointer] = tmp;

        return newText;

    }

    public static void main(String[] args) {
        System.out.println(swap("abcde", 1, 3));
    }
}
