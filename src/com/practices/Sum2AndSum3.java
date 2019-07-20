package com.practices;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

class Sum2AndSum3 {

    private static boolean Sum2 (int[] arr, int target) {
        Set<Integer> mem = new HashSet<>();
        for (int i = 0;i < arr.length; i++) {
            if (mem.contains(target - arr[i])) return true;
            else mem.add(arr[i]);
        }

        return false;
    }

    private static boolean Sum3 (int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> mem = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (mem.contains(target - arr[i] - arr[j])) return true;
                else mem.add(arr[j]);
            }
        }

        return false;
    }

    public static void main(String[] args){

        //out.println(Sum2(new int[]{2, 4, 6, 5, 9, 8}, 11));
        out.println(Sum3(new int[]{2, 4, 6, 5, 9, 8}, 19));
    }
}
