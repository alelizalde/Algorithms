package com.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindParentsOnTree {

	static ArrayList<Integer> parents = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int[][] parentChildPairs = new int[][] {
			{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}
		};


		FindParents(9,SaveParents(parentChildPairs));
		ArrayList<Integer> parentsA = (ArrayList<Integer>) parents.clone();
		System.out.println(parents);
		parents.clear();
		FindParents(5,SaveParents(parentChildPairs));
		ArrayList<Integer> parentsB = (ArrayList<Integer>) parents.clone();
		System.out.println(parents);
		
		for (Integer parent : parentsA) {
			System.out.println(parentsB.indexOf(parent));
			}
		
		
	}
	public static Map<Integer, ArrayList> SaveParents(int[][] pcp){

		Map<Integer, ArrayList> hashMap = new HashMap<Integer, ArrayList>();
		Integer child = -1;
		Integer parent = -1;

		for(Integer i=0;i<pcp.length;i++) {
			//System.out.println(pcp[i][1]);
			child = pcp[i][1];
			parent=pcp[i][0];
			insertParent(hashMap,child,parent);
		}
		System.out.println(hashMap);
		return hashMap;
	}

	public static void insertParent(Map<Integer, ArrayList> hashMap,Integer child,Integer parent){

		if(hashMap.containsKey(child)) {
			hashMap.get(child).add(parent);
		}else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(parent);
			hashMap.put(child, list);
		}

	}
	public static void FindParents(int number, Map<Integer, ArrayList> hashMap){
		int parent =-1;
		if(hashMap.containsKey(number)) {

			ArrayList<Integer> list = hashMap.get(number);
			for(Integer value:list) {
				parents.add(value);
				FindParents(value, hashMap);
			}

		}
	}

}
