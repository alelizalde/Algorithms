package com.practices;

public class rearrangeArray {

	public static void rearrangeArray(int arr[],int n){
		int temp;
		for(int x=1;x<n;x+=2) {
			if(arr[x-1]>arr[x]) {
				temp = 	arr[x-1];
				arr[x-1]=arr[x];
				arr[x]=temp;
			}
			if(x+1<n && arr[x+1]>arr[x]) {
				temp = 	arr[x+1];
				arr[x+1]=arr[x];
				arr[x]=temp;	
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 9, 6, 8, 3, 7 };
		int n = A.length;
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");

		System.out.println();

		rearrangeArray(A, n);

		// print output array
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");
	}

}
