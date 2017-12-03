package com.examples;

import java.util.HashMap;
import java.util.Map.Entry;

public class WordCloudData {

	public static HashMap<String,Integer> wordCloudData(String message) {
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		
		int start=0;
		for(int x=0;x<message.length()-1;x++) {
			if( ((int)message.charAt(x)>=32 && (int)message.charAt(x)<=38) ||
			((int)message.charAt(x)>=40 && (int)message.charAt(x)<=47)){
				if(start==x) {
					x++;
					start=x+1;
					continue;
				}
				if(words.containsKey(message.substring(start, x).toLowerCase())) {
					int count=words.get(message.substring(start, x).toLowerCase())+1;
					words.put(message.substring(start, x).toLowerCase(), count);
				} else {
					words.put(message.substring(start, x).toLowerCase(), 1);
				}
				if((int)message.charAt(x+1)==32) {
					x++;
				}
				start=x+1;
			}
		}
		return words;
	}
	
	public static void main(String[] args) {
		String message =   "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake."
				+ "The bill came to five dollars.";
		HashMap<String, Integer> words = wordCloudData(message);
		for(Entry<String, Integer> word:words.entrySet()) {
				System.out.println(word.getKey()+" - "+word.getValue());
		}

	}

}
