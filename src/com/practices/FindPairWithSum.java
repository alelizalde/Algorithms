package com.practices;

import java.util.ArrayList;
import java.util.List;

class FindPairWithSum {

    static public boolean findPairWithSum(int[] arr, int sum) {
        List<Integer> list = new ArrayList<>();

        for (int val : arr) {
            if (list.contains(val)) return true;
            list.add(sum - val);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPairWithSum(new int[]{1, 2, 3, 4}, 8));
        System.out.println(findPairWithSum(new int[]{1, 2, 4, 4}, 8));
        System.out.println(findPairWithSum(new int[]{1, 2, 6, 4}, 8));
    }
}