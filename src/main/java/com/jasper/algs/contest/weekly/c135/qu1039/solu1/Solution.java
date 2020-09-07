package com.jasper.algs.contest.weekly.c135.qu1039.solu1;

/**
 * 1039. 多边形三角剖分的最低得分
 * 
 * <p> 动态规划
 */
class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for(int i=n-3; i>=0; i--) {
            for(int j=i+2; j<n; j++) {
                int multi = A[i] * A[j];
                dp[i][j] = Integer.MAX_VALUE;
                for(int x = i+1; x < j; x++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][x] + multi * A[x] + dp[x][j]);
            }
        }

        return dp[0][n-1];
    }
}