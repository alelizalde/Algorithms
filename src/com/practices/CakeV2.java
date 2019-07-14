package com.practices;

import java.util.HashMap;

public class CakeV2 {

	public static HashMap<Integer, Integer>  loot = new HashMap<Integer, Integer>();

	public static void main (String args[]) {
		HashMap<Integer, Integer> cakes = new HashMap<Integer, Integer>();
/*		cakes.put(7, 160);
		cakes.put(3, 90);
		cakes.put(2, 15);
		cakes.put(6, 0);*/
		cakes.put(7, 100);
		cakes.put(6, 90);
		cakes.put(4, 20);
		FindCakes(cakes,10);
		for(int weight:loot.keySet()) {
			if(loot.get(weight)!=0 && cakes.get(weight)!=0) {
				System.out.println("weight:"+weight+" loot:"+loot.get(weight)+" quantity:"+loot.get(weight)/cakes.get(weight));
			}
		}
	}

	private static void FindCakes(HashMap<Integer, Integer> cakes,int totalCapacity) {
		int capacityLeft=totalCapacity;
		int cakeType=0;
		int maxLoot=0;
		for(int weight:cakes.keySet()) {
			if(capacityLeft<=totalCapacity && weight>0) {
				if(maxLoot < (totalCapacity/weight*cakes.get(weight)) ) {
					maxLoot =totalCapacity/weight*cakes.get(weight);
					capacityLeft=totalCapacity-(weight*(totalCapacity/weight));
					cakeType=weight;
				}
			}
		}
		loot.put(cakeType, maxLoot);
		if(capacityLeft>0 && capacityLeft!=totalCapacity) {
			FindCakes(cakes, capacityLeft);
		}
	}

}
