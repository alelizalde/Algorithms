package com.practices;

import java.util.HashMap;
import java.util.Map;

public class MergeIntervals {

	public static Map<Integer, Integer> resultList = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		int[][] arr = { { 1, 5 }, { 2, 3 }, { 4, 6 }, { 7, 8 }, 
				{ 8, 10 },  {12, 15} };

		mergeIntervals(arr);

	}

	public static void mergeIntervals(int[][] arr) {

		int start=-1;
		int end=-1;
		
		for(int x=0;x<arr.length;x++) {

			start = arr[x][0];
			end = arr[x][0];
			if(end>start)
				end = arr[x][1];
			resultList.put(start,end);

		}

		System.out.println(resultList);
	}

}
