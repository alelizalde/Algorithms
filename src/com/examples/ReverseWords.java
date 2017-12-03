package com.examples;

public class ReverseWords {

	public static String reverseWords(String message) {

		char[] messageChars = message.toCharArray();

		// first we reverse all the characters in the entire messageChars array
		// this gives us the right word order
		// but with each word backwards
		reverseCharacters(messageChars, 0, messageChars.length - 1);

		// now we'll make the words forward again
		// by reversing each word's characters

		// we hold the index of the *start* of the current word
		// as we look for the *end* of the current word
		int currentWordStartIndex = 0;
		for (int i = 0; i <= messageChars.length; i++) {

			// found the end of the current word!
			if (i == messageChars.length || ( (int)messageChars[i] >=32 && (int)messageChars[i] <=46) ) {

				// if we haven't exhausted the string, our
				// next word's start is one character ahead
				reverseCharacters(messageChars, currentWordStartIndex, i - 1);
				currentWordStartIndex = i + 1;
			}
		}

		return new String(messageChars);
	}

	private static void reverseCharacters(char[] messageChars, int startIndex, int endIndex) {

		// walk towards the middle, from both sides
		while (startIndex < endIndex) {
			// swap the front char and back char
			char temp = messageChars[startIndex];
			messageChars[startIndex] = messageChars[endIndex];
			messageChars[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}

	public static void main(String args[]) {
		String message =".find you will pain only .go you recordings security the into if";

		System.out.println(reverseWords(message));
	}

}
