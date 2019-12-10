package com.practices;

public class CountSquaresOfOnes {
    static public int count(int[][] matrix) {
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(count(new int[][] {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        }));
    }
}
