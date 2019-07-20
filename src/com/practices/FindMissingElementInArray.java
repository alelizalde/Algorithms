package com.practices;

import static java.lang.System.out;
import java.util.*;

public class FindMissingElementInArray {

    private static int findMissingElement(int[] arr1, int[] arr2){
        if (arr2.length > arr1.length) {
            return findMissingElement(arr2, arr1);
        }
        List<Integer> mem = new ArrayList<>();

        for (int x : arr2) mem.add(x);
        for (int x : arr1) if (!mem.contains(x)) return x;
        return -1;
    }

    private static int findMissingElementInPlace(int[] arr1, int[] arr2){
        //Trading Space for time complexity
        if (arr2.length > arr1.length) {
            return findMissingElementInPlace(arr2, arr1);
        }
        Arrays.sort(arr1); // Neds to change from QuickSort to MergeSort as QS uses space.
        Arrays.sort(arr2);
        //out.println(Arrays.toString(arr1));
        //out.println(Arrays.toString(arr2));
        for (int i =0; i< arr2.length;i++) {
            if(arr1[i] != arr2[i]) return arr1[i];
        }

        return arr1.length;
    }

    private static int findMissingElementBiFlip(int[] arr1, int[] arr2){

        int sumXor1 = 0;
        for (int x : arr1) sumXor1 ^= x;
        for (int x : arr2) sumXor1 ^= x;

        return sumXor1;
    }

    public static void main(String[] args) {
        out.println(findMissingElement(new int[]{12, 6, 8, 9}, new int[]{12, 6, 8, 9, 7}));
        out.println(findMissingElementInPlace(new int[]{12, -6, 8, 9}, new int[]{12, -6, 8, 9, 7}));
        out.println(findMissingElementBiFlip(new int[]{12, -6, 8, 9}, new int[]{12, -6, 8, 9, 7}));
    }
}


