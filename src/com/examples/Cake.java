package com.examples;

import java.util.HashMap;


public class Cake {
	public static void main (String args[]) {
		HashMap<Integer, Integer> cakes = new HashMap<Integer, Integer>();
		cakes.put(1, 17);
		cakes.put(5, 20);
		cakes.put(7, 10);
		FindCakes(cakes);
	}

	public static void FindCakes(HashMap<Integer, Integer> cakes) {
		int weight[] = new int[cakes.size()];
		int loot[] = new int[cakes.size()];
		int count[] = new int[cakes.size()];
		int x=0;
		for(int n:cakes.keySet()) {
			weight[x]=n;
			loot[x]=cakes.get(n);
			x++;
		}
			
		HashMap<Integer,Integer> results = new HashMap<Integer,Integer>();
		for(int i=0;i<count.length;i++) {
			count[i]=1;
		}
		results = FindCakesCombinations(weight,loot,count,0,results);
		for(int n:results.keySet())System.out.println("weight["+n+"], loot["+results.get(n)+"]");
	}

	public static HashMap<Integer,Integer>  FindCakesCombinations(int weight[],int loot[],int count[],int pos,HashMap<Integer,Integer> results) {
		int TotalWeight=0;
		int TotalLoot=0;
		
		for(int i=pos;i<count.length;i++) {
			if(count[i]==0)continue;
			for(int x=0;x<count.length;x++) {
				if(count[x]!=0) {
					TotalWeight+=weight[x];
					TotalLoot+=loot[x];
				}
			}
			results.put(TotalWeight, TotalLoot);
			count[i]--;
			FindCakesCombinations(weight,loot,count,i,results);
		}
	return results;
	}	
}
