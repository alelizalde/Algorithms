package com.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Various {

    private static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] d = new int[2*n];
        List<Integer> q = new ArrayList<>();
        Arrays.fill(d, 999999999);
        d[0] = d[n] = 0;
        q.add(0);
        q.add(n);
        while(!q.isEmpty()){
            int cur = q.remove(0);
            if(cur < n){
                for(int[] r : red_edges){
                    if(r[0] == cur && d[r[1]+n] > d[cur] + 1){
                        d[r[1]+n] = d[cur] + 1;
                        q.add(r[1]+n);
                    }
                }
            }else{
                for(int[] r : blue_edges){
                    if(r[0] == cur-n && d[r[1]] > d[cur] + 1){
                        d[r[1]] = d[cur] + 1;
                        q.add(r[1]);
                    }
                }
            }
        }
        int[] ret = new int[n];
        for(int i = 0;i < n;i++){
            ret[i] = Math.min(d[i], d[i+n]);
            if(ret[i] > 5000000){
                ret[i] = -1;
            }
        }
        return ret;
    }

    private static int mctFromLeafValues(int[] arr) {
        int length =arr.length;
        long[][] dp = new long[length][length];
        for(int len = 1;len <= length;len++){
            for(int i = 0;i+len-1 < length;i++){
                int j = i+len-1;
                if(len == 1){
                    dp[i][i] = 0;
                }else{
                    dp[i][j] = Long.MAX_VALUE;
                    for(int k = i+1;k <= j;k++){
                        int maxl = 0;
                        for(int l = i;l < k;l++){
                            maxl = Math.max(maxl, arr[l]);
                        }
                        int maxr = 0;
                        for(int l = k;l <= j;l++){
                            maxr = Math.max(maxr, arr[l]);
                        }
                        dp[i][j] = Math.min(dp[i][j], dp[i][k-1] + dp[k][j] + maxl*maxr);
                    }
                }
            }
        }
        return (int)dp[0][length-1];
    }

    private static int maxAbsValExpr(int[] a, int[] b) {
        int n = a.length;

        int ans = 0;
        int maxmm = Integer.MIN_VALUE / 2;
        int maxmp = Integer.MIN_VALUE / 2;
        int maxpm = Integer.MIN_VALUE / 2;
        int maxpp = Integer.MIN_VALUE / 2;
        for(int i = 0;i < n;i++){
            maxmm = Math.max(maxmm, -a[i]-b[i]-i);
            maxmp = Math.max(maxmp, -a[i]+b[i]-i);
            maxpm = Math.max(maxpm, a[i]-b[i]-i);
            maxpp = Math.max(maxpp, a[i]+b[i]-i);
            ans = Math.max(ans, maxmm + a[i]+b[i]+i);
            ans = Math.max(ans, maxmp + a[i]-b[i]+i);
            ans = Math.max(ans, maxpm - a[i]+b[i]+i);
            ans = Math.max(ans, maxpp - a[i]-b[i]+i);
        }
        return ans;
    }

    public static void main(String[] args) {

        //shortestAlternatingPaths(3,  new int[][]{{0,1}}, new int[][]{{2,1}});
        mctFromLeafValues(new int[]{6, 2, 4});
        maxAbsValExpr(new int[]{1,-2,-5,0,10}, new int[]{0,-2,-1,-7,-4});

    }
}


/*
{1, 2, 3},
{2, 3, 3},
{0, 1, 2}

* */