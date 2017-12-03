package com.examples;

import java.util.Arrays;
import java.util.Collections;

public class MergeSortSolution {

	public static void main(String[] args) {
		
		int array[] = {9,1,8,2,7,3,6,4,5};
		Arrays.parallelSort(array, 0, array.length);
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+ " ");
		}
		//mergesort(array);

	}
	public static void mergesort(int array[]) {
		mergesort(array,new int[array.length],0,array.length);
	}

	public static void mergesort(int array[],int tmpArray[],int leftStart,int rightEnd) {
		if(leftStart>=rightEnd) {
			return;
		}

		int middle = (leftStart+rightEnd)/2;
		mergesort( array,tmpArray,leftStart,middle);
		mergesort( array,tmpArray,middle+1,rightEnd);
		mergeHalves(array,tmpArray, leftStart,rightEnd);
	}

	public static void mergeHalves(int array[],int tmpArray[],int leftStart,int rightEnd) {
		int leftEnd = (rightEnd+leftStart)/2;
		int rightStart = leftEnd+1;
		int size = rightEnd -leftStart +1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while(left<=leftEnd && right <= rightEnd) {
			if(array[left]<=array[right]) {
				tmpArray[index]=array[left];
				left++;


			}else {
				tmpArray[index]=array[right];
				right++;
			}
			index++;
		}
		System.arraycopy(array, left, tmpArray, index, leftEnd-left+1);
		System.arraycopy(array, right, tmpArray, index, rightEnd-right+1);
		System.arraycopy(tmpArray, leftStart, array, leftStart, size);
	}
}
