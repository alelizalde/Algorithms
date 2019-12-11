package com.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReconstructMatrix {
    static private List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        boolean[][] res = new boolean[2][colsum.length];
        for (int i = 0; i < colsum.length; ++i) {
            res[0][i] = colsum[i] == 2 || (colsum[i] == 1 && lower < upper);
            res[1][i] = colsum[i] == 2 || (colsum[i] == 1 && !res[0][i]);
            upper -= res[0][i] ? 1 : 0;
            lower -= res[1][i] ? 1 : 0;
        }
        return lower == 0 && upper == 0 ? new ArrayList(Arrays.asList(res[0], res[1])) : new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(reconstructMatrix(5, 5, new int[]{2,1,2,0,1,0,1,2,0,1}));
    }
}