package com.examples;

public class getMaxProfit {

	public static int getMaxProfitm(int[] stockPricesYesterday) {

		  if (stockPricesYesterday.length < 2) {
			    throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
			}
		  
		int maxProfit = 0;

		// go through every time
		for (int earlierTime = 0; earlierTime < stockPricesYesterday.length; earlierTime++) {
			
			int earlierPrice = stockPricesYesterday[earlierTime];
			
			// for every time, got through every OTHER time
			for (int laterTime = earlierTime + 1; laterTime < stockPricesYesterday.length; laterTime++) {

				// and use those to find the earlier and later prices
				int laterPrice   = stockPricesYesterday[laterTime];

				// see what our profit would be if we bought at the
				// min price and sold at the current price
				int potentialProfit = laterPrice - earlierPrice;

				// update maxProfit if we can do better
				if(maxProfit==0 && potentialProfit<0)maxProfit=potentialProfit;
				maxProfit = Math.max(maxProfit, potentialProfit);
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  //int[] stockPricesYesterday = new int[] {15, 13, 11, 9, 22, 2};
		//int[] stockPricesYesterday = new int[] {4, 4, 4, 4, 4, 4};
		int[] stockPricesYesterday = new int[] {};

		  System.out.println(getMaxProfitm(stockPricesYesterday));
	}

}