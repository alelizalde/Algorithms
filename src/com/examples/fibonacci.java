package com.examples;

public class fibonacci {

	public static int solveFibonacci(int f) {
		
		if (f < 0) {
	        throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
	    } else if (f == 0 || f == 1) {
	        return f;
	    }
		
		int prevPrev = 0;   // 0th fibonacci
		int prev = 1;       // 1st fibonacci
		int current = 0;  // Declare and initialize current
		for (int n =0;n<f;n++) {
			current=prev+prevPrev;
			prevPrev=prev;
			prev=current;
		}
		return current;
	}

	public static void main(String[] args) {
		System.out.println(solveFibonacci(5));

	}

}
