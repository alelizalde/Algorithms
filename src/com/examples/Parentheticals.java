package com.examples;

public class Parentheticals {

	public static void main(String[] args) {
		String message ="Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
		int position = 10;
		System.out.println(findPosition(message, position));

	}

	private static int findPosition(String message, int position) {
		int counter=0;
		//	System.out.println(message.substring(position,position+1) );
		char c[] = message.substring(position,position+1).trim().toCharArray();
		if((int)c[0] != 40) {
			return -1;
		}

		for(int x=position;x<message.length();x++) {
			c = message.substring(x,x+1).toCharArray();
			//System.out.println(c);
				if((int)c[0] == 40) {
					counter++;
				}
				
				if((int)c[0] == 41) {
					counter--;
				}
				
				if(counter==0) {
					return x;
				}
		}
		return -1;
	}

}
