package com.examples;

import java.util.Random;

public class Rand7 {

	public static int rand7() {

		while (true) {

			Random rand = new Random();

			// do our die rolls
			int roll1 = rand.nextInt(5) + 1;
			int roll2 = rand.nextInt(5) + 1;

			int outcomeNumber = (roll1-1) * 5 + (roll2-1) + 1;

			// if we hit an extraneous
			// outcome we just re-roll
			if (outcomeNumber > 21) continue;

			// our outcome was fine. return it!
			return outcomeNumber % 7 + 1;
		}
	}
	
	public static int rand7v2() {
		
		Random rand = new Random();
		
		int roll1 = rand.nextInt(5) + 1;
		System.out.println(roll1);
		int roll2 = rand.nextInt(5) + 1;
		System.out.println(roll2);
		int[] r7 = {6,7,0,0,0};
		int roll7=roll2*r7[roll2-1];
		if(roll1>roll7) {
			return roll1;
		}else {
			return r7[roll2-1];
		}
		
		
	}
	
	public static void main(String args[]) {
		//System.out.println(rand7());
		System.out.println(rand7v2());
	}

}
