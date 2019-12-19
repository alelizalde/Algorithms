import java.util.Arrays;

class AllWaysToSumNumber {

    private static int numOfWays(int n) {
        int[][] dp = new int[n-1][n+1];
        Arrays.fill(dp[0], 1);
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(j > i) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-(i+1)];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(numOfWays(5));
        System.out.println(numOfWays(10));
    }

}