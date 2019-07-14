package com.practices;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SortScores {

	public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

		// array of 0s at indices 0..highestPossibleScore
		int[] scoreCounts = new int[highestPossibleScore + 1];

		// populate scoreCounts
		for (int score : unorderedScores) {
			scoreCounts[score]++;
		}

		// populate the final sorted array
		int[] sortedScores = new int[unorderedScores.length];
		int currentSortedIndex = 0;

		// for each item in scoreCounts
		for (int score = highestPossibleScore; score >= 0; score--) {
			int count = scoreCounts[score];

			// for the number of times the item occurs
			for (int occurrence = 0; occurrence < count; occurrence++) {

				// add it to the sorted array
				sortedScores[currentSortedIndex] = score;
				currentSortedIndex++;
			}
		}

		return sortedScores;
	}

	public static TreeMap<Integer,Integer> sortScoresV2(int[] unorderedScores, int highestPossibleScore) {
		TreeMap<Integer, Integer> sortedScores = new TreeMap<Integer,Integer>(Collections.reverseOrder());

		for(int score:unorderedScores) {
			int count = 1;
			if(sortedScores.containsKey(score)) {
				count = sortedScores.get(score)+1;
			}
			sortedScores.put(score, count);
		}

		return sortedScores;
	}

	public static void main(String[] args) {
		int[] unsortedScores = {37, 89, 41,91,90, 65, 91, 53};
		final int HIGHEST_POSSIBLE_SCORE = 100;

		//int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
		TreeMap<Integer,Integer> sortedScores = sortScoresV2(unsortedScores, HIGHEST_POSSIBLE_SCORE);

		for(Map.Entry<Integer,Integer> score:sortedScores.entrySet()) {
			for(int count=1;count<=score.getValue();count++) {
				System.out.println(score.getKey());
			}
		}
	}

}
