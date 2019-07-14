package com.practices;

import java.util.HashMap;

public class WordDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "After beating the eggs, Dana read the next step:" +
				"Add milk and eggs, then add flour and sugar.";
		str=str.replace(":", " ");
		str=str.replace(".", " ");
		str=str.toLowerCase();
		String input[] = str.split(" ");
		DoTheCount(input);
	}

	public static void DoTheCount(String input[]) {

		//Map<Integer, Integer> countMap = new TreeMap<>();
		HashMap<String, Integer> countMap = new HashMap<>();
		for (String n : input) {
			countMap.compute(n, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					return val + 1;
				}
			});
		}

		System.out.println(countMap);
	}

}
