package com.examples;

public class Loop {

	/*Driver function to check for above function*/
	public static void main (String[] args)
	{

		//int arr[] = {1, 2, 3, 4, 5};
		//int n = arr.length;
		//runLoop(n);
		//long res = factorial(5);
		//long res = fibonacci(10);
		//System.out.println(printCountRec(4));
		//System.out.println(fibonacciLong(4));
/*		int set[] = {4, 34, 2, 12,4};
        int sum = 9;
        n = set.length;
        if (findSum(set, n, sum) == true)
           System.out.println("Found a subset with given sum");
        else
           System.out.println("No subset with given sum");
		System.out.println("End");*/
/*		String set[] = {"a", "b", "b", "a","c"};
        n = set.length;
        findSet(set, n, "abc");*/
/*        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int x = 3;
        int result = binarySearch(arr,0,n-1,x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);*/
		System.out.println(gcd(24,54));
        
	}

	public static boolean runLoop(int n){
		System.out.print("["+n+"]");
		if(n<1){ 
			System.out.println("false");
			return false;
		}
		return runLoop(n-1) || 
				runLoop (n-1);

	}

	public static long factorial(int n) { 
		if (n == 1) return 1; 
		return n * factorial(n-1); 
	} 

	public static long fibonacci(int n) {
		long[] f = new long[n+1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++)
			f[i] = f[i-1] + f[i-2];
		return f[n];
	}

	public static long fibonacciLong(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fibonacciLong(n-1) + fibonacciLong(n-2);
	} 

	static int printCountRec(int dist)
	{
		// Base cases
		if (dist<0)    
			return 0;
		if (dist==0)    
			return 1;

		// Recur for all previous 3 and add the results
		return printCountRec(dist-1) + 
				printCountRec(dist-2) +
				printCountRec(dist-3);
	}
	static boolean findSum(int set[],int n,int sum) {
        System.out.println("n["+n+"]sum["+sum+"]");
		if(sum == 0 )
			return true;
		if (sum != 0 && n == 0) 
			return false;

	       if (set[n-1] > sum)
	           return findSum(set, n-1, sum);

		return findSum(set, n-1, sum) || 
				findSum(set, n-1, sum-set[n-1]);
	}

	static boolean findSet(String set[],int n,String str) {
        System.out.println("n["+n+"]sum["+str+"]");

        if (str.indexOf(set[n])==0) {
        		str+=set[n].toString();
        }

		return findSet(set, n-1, str) || 
				findSet(set, n-1, set[n-1]);
	}
	static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
	
	static int gcd(int a, int b)
    {
		  if(a == 0 || b == 0) return a+b; // base case
		  return gcd(b,a%b);
    }
	
}

