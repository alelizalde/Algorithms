package com.practices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

class BeautifulArray {

    static Map<Integer, int[]> memo;
    private static int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    private static int[] f(int N) {
        int ret[] = new int[N];
        for (int i = 0; i < ret.length; i++) {
            int index = 0;
            int off = N;
            for (int n = i; n > 0; n >>= 1) {
                int nbit = (n & 1);
                int obit = (off & 1);
                off = (off + 1) / 2;
                index += nbit * off;
                off -= (obit & nbit);
            }
            ret[index] = i + 1;
        }
        return ret;
    }

    public static void main(String[] args){
        out.println(Arrays.toString(beautifulArray(9)));
    }
}




























































