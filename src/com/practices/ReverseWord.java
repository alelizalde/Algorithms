package com.practices;

import static java.lang.System.out;

class ReverseWord {

    private static String reverseCharArray(String text) {
        char[] output = new char[text.length()];
        int textPointer = text.length() - 1;
        for (int i = 0; i< text.length(); i++) {
            output[i] = text.charAt(textPointer--);
        }

        return new String(output);
    }

    private static String reverseCharArray2(String text) {
        char[] output = new char[text.length()];
        int pointer = text.length() - 1;
        for (char t : text.toCharArray()) {
            output[pointer--] = t;
        }

        return new String(output);
    }

    private static String reverse(String text) {
        StringBuilder output = new StringBuilder();
        for (char t : text.toCharArray()) {
            output.insert(0,t);
        }
        return output.toString();
    }


    public static void main(String[] args){

        assert reverse("").equals("") : "Incorrect result";
        assert reverseCharArray("").equals("") : "Incorrect result";
        assert reverseCharArray2("").equals("") : "Incorrect result";

        assert reverse("Hello world").equals("dlrow olleH") : "Incorrect result";
        assert reverseCharArray("Hello world").equals("dlrow olleH") : "Incorrect result";
        assert reverseCharArray2("Hello world").equals("dlrow olleH") : "Incorrect result";

        out.println(reverse(""));
        out.println(reverseCharArray(""));
        out.println(reverseCharArray2(""));

        out.println(reverse("Hello world"));
        out.println(reverseCharArray("Hello world"));
        out.println(reverseCharArray2("Hello world"));
    }
}




























































