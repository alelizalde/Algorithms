package com.examples;

public class changePossibilitiesBottomUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] denominations = {1,3,5};
		int[] denominations = {1,2,3};
		int amount =5;
		System.out.println(mchangePossibilitiesBottomUp(amount,denominations));

	}
	
	public static int mchangePossibilitiesBottomUp(int amount, int[] denominations) {
	    int[] waysOfDoingNCents = new int[amount + 1]; // array of zeros from 0..amount
	    waysOfDoingNCents[0] = 1;

	    for (int coin : denominations) {
	        for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
	            int higherAmountRemainder = higherAmount - coin;
	            waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
	            System.out.println("waysOfDoingNCents["+higherAmount+"]"+waysOfDoingNCents[higherAmount]);
	        }
	    }

	    return waysOfDoingNCents[amount];
	}
	
}
