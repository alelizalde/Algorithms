package com.practices;

public class InsertionSortSolution {
 public static void main(String args[]) {
	 int array[] = {9,2,3,5,6,4, 3,1,7};
	 array = insertion_sort(array);
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+ " ");
		}
	 
 }
 public static int[] insertion_sort(int array[]) {
	 int value;
	 int previous;
	    for (int slot=0;slot<array.length;slot++) { 
	        value = array[slot];
	        previous = slot - 1;
	        while( previous > -1 && array[previous] > value){
	            array[previous + 1] = array[previous];
	            previous--;
	        }
	        array[previous + 1] = value;
	        
	    }
	    return array;
	    		
 }
}
