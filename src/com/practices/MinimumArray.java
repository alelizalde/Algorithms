package com.practices;

import java.util.*;

public class MinimumArray {
    static private double[] findMin2(double[] input) {
        double[] result = new double[2];
        result[0] = Double.MAX_VALUE;
        result[1] = Double.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (input[i] < result[0] || input[i] < result[1]) {
                if (input[i] < result[0]) {
                    result[1] = result[0];
                    result[0] = input[i];
                } else {
                    result[1] = input[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMin2(new double[]{0.1, -1.0, 4.5, 2.2, 0.001})));
    }
}
