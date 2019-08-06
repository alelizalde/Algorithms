package com.practices;

public class MovesToMakeZigzag {
    static int INF = Integer.MAX_VALUE;
    static public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[] sums = new int[]{0, 0};

        for (int i = 0; i < n; i++) {
            int left = i == 0 ? INF : nums[i - 1];
            int right = i == n - 1 ? INF : nums[i + 1];
            int goal = Math.min(left, right) - 1;

            if (nums[i] > goal)
                sums[i % 2] += nums[i] - goal;
        }

        return Math.min(sums[0], sums[1]);
    }

    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[]{9,6,1,6,2}));
    }
}
