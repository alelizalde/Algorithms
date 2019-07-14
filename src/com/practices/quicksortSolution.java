package com.practices;

public class quicksortSolution {

	public static void main( String args[]) {
		int array[]={1,9,2,8,3,7,4,6,5};
		quicksort(array);
	}

	public static void quicksort(int array[]){
		quicksort(array,0,array.length-1);
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+ " ");
		}
	}

	public static int[] quicksort( int array[], int left, int right){
		if(left>=right){
			return null;
		}
		int pivot = array[(left+right)/2];
		int index = partition(array, left, right, pivot);
		quicksort(array, index, right);
		quicksort(array, left, index-1);
        return array;
	}

	public static int partition(int array[], int left, int right, int pivot){
		while(left<right){
			while(array[left]<pivot){
				left++;
			}
			while(array[right]>pivot){
				right--;
			}

			if(left<=right){
				swap(array,left,right);
				left++;
				right--;
			}
		}
		return left;
	}
	public static int[] swap(int arr[],int left, int right) {
		int tmpval = arr[left];
		arr[left] =arr[right];
		arr[right] =tmpval;
		return arr;
	}
}
