package com.practices;

public class highestProductOf3 {
	static public void main(String args[]) {
		//int[] arrayOfInts = new int[]{1, 10, -5, 1, -100};
		int[] arrayOfInts = new int[]{2, 3, 5, 2, 7};
		System.out.println(highestProductOf3m(arrayOfInts));
	}
	static public int highestProductOf3m(int[] arr){

		int h3 = arr[0]*arr[1]*arr[2];
		int l3 = arr[0]*arr[1]*arr[2];
		int h2 = arr[0]*arr[1];
		int l2 = arr[0]*arr[1];
		int h = Math.max(arr[0],arr[1]);
		int l = Math.min(arr[0],arr[1]);
		for(int i=2;i<arr.length;i++) {
			System.out.println(h3);
			int current=arr[i];
			h3=Math.max(Math.max(h3, h2*current), l2*current);
			h2=Math.max(Math.max(h2, h*current), l*current);
			l2=Math.min(Math.max(l2, h*current), l*current);
			h=Math.max(h, current);
			l=Math.min(l, current);

		}

		return h3;
	}
}
