package com.practices;

import java.util.*;

import static java.lang.System.out;


class Largest1BorderedSquare {



    static public int largest1BorderedSquare2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] hor = new int[row][col];// horizontal array
        int[][] ver = new int[row][col];// vertical array

        // construction horizontal
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (j == 0) {// first column for every row
                        hor[i][j] = 1;
                    } else {
                        hor[i][j] = hor[i][j - 1] + 1;
                    }
                }
            }
        }

        // construction vertical
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[j][i] == 1) {
                    if (j == 0) {// first row for every column
                        ver[j][i] = 1;
                    } else {
                        ver[j][i] = ver[j - 1][i] + 1;
                    }
                }
            }
        }

        // calculate
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = Math.min(hor[i][j], ver[i][j]);
                while (cur > max) {
                    if (hor[i - cur + 1][j] >= cur
                            && ver[i][j - cur + 1] >= cur) {
                        max = cur;
                    } else {
                        cur--;
                    }
                }
            }
        }

        return max * max;
    }


    static public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][][] dp = new int[row + 1][col + 1][2];
        int max = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1; // col
                    dp[i][j][1] = dp[i - 1][j][1] + 1; // row
                    int cur = Math.min(dp[i][j][0], dp[i][j][1]);
                    while (cur > max) {
                        if (dp[i - cur + 1][j][0] >= cur
                                && dp[i][j - cur + 1][1] >= cur) { //check diagonals
                            max = cur;
                        } else {
                            cur--;
                        }
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return max * max;
    }


    public static void main(String[] args) {

        System.out.println(largest1BorderedSquare(new int[][]{{1,1,1,1},{1,0,1,1},{1,0,1,1}}));
        //System.out.println(largest1BorderedSquare(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        //System.out.println(largest1BorderedSquare2(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        //System.out.println(largest1BorderedSquare(new int[][]{{0,1},{1,1}}));
        //System.out.println(largest1BorderedSquare2(new int[][]{{0,1},{1,1}}));
    }
}


/*

111
101
111

i=1
j=3
side = 1
max = 1

00 00 00 00
00 11 21 31
00 12 00 12
00 13 21 33

01
11

00 00 00
00 00 11
00 11 22

1111
1011
1011

cur = 2
max = 4

00 00 00 00 00
00 11 21 31 41
00 12 00 12 22
00 13 00 13 23

[
[[0, 0], [0, 0], [0, 0], [0, 0], [0, 0]],
[[0, 0], [1, 1], [2, 1], [3, 1], [4, 1]],
[[0, 0], [1, 2], [0, 0], [1, 2], [2, 2]],
[[0, 0], [1, 3], [0, 0], [1, 3], [2, 3]]
]

*/