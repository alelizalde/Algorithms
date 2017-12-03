package com.examples;

public class RunTemperatures {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Temperatures temps = new Temperatures();
		temps.insert(10);
		temps.insert(11);
		temps.insert(12);
		temps.insert(12);
		temps.insert(5);
		temps.insert(17);
		System.out.println("Max: "+temps.getMax());
		System.out.println("Min: "+temps.getMin());
		System.out.println("Mode: "+temps.getMode());
		System.out.println("Mean: "+temps.getMean());
	}
}
