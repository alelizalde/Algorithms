package com.practices;

import java.util.HashMap;
import java.util.Map;

public class NumRollsToTarget {

    static int MOD = 1000000000 + 7;
    static Map<String, Integer> memo = new HashMap<>();
    static public int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0)
            return 1;
        if (d == 0 || target == 0)
            return 0;

        String key = d + "-" + target;
        if (memo.containsKey(key))
            return memo.get(key);

        int result = 0;
        for (int i = 1;i<= f; i++) {
            if (target >= i) {
                result = (result + numRollsToTarget(d - 1, f, target - i)) % MOD;
            } else {
                break;
            }
        }

        memo.put(key, result);

        return result;
    }
    public static void main(String[] args) {
        //System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(30, 30, 500));
        //System.out.println(numRollsToTarget(2, 6, 7));
    }
}
