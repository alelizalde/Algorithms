package com.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountRepetitions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1,2,3,4,2,1,1,1,1};
		DoTheCount(input);
	}

	public static void DoTheCount(int input[]) {

		//Map<Integer, Integer> countMap = new TreeMap<>();
		HashMap<Integer, Integer> countMap = new HashMap<>();
		for (int n : input) {
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
