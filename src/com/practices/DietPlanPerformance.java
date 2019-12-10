package com.practices;

public class DietPlanPerformance {
    static public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int point = 0;
        for (int i = 0, win = 0; i < calories.length; ++i) {
            win += calories[i];
            if (i >= k - 1) {                                          // reach a k sequence already.
                if (i > k - 1) win -= calories[i - k];                 // more than k sequence already
                if (win < lower) --point;
                if (win > upper) ++point;
            }
        }
        return point;
    }

    public static void main(String[] args) {

        System.out.println(dietPlanPerformance(new int[]{1,2,3,4, 5}, 1, 3, 3));
    }
}
