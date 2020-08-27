package com.jasper.algs.contest.weekly.c203.qu1563.solu1;

/**
 * 1563. 石子游戏 V
 * 
 * <p> 动态规划
 */
class Solution {
    public int stoneGameV(int[] stoneValue) {
        // 动态规划
        int n = stoneValue.length;
        int[][][] dp = new int[n][n][3];
        
        // 初始化填表
        for(int i=0; i<n; i++) {
            int j = i;
            // 求分数+和、求和
            dp[i][j][2] = dp[i][j][0] = stoneValue[j]; 
        }

        // 对角线方向填表
        for(int dist=1; dist<n; dist++) {
            for(int i=0; i+dist<n; i++) {
                int j = i+dist;
                // 求和
                dp[i][j][0] = dp[i][j-1][0] + stoneValue[j];
                // 求分数
                int i0=i, j0=i, i1=i+1, j1=j;
                while(j0<j) {
                    if(dp[i0][j0][0] < dp[i1][j1][0])
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i0][j0][2]);
                    else if(dp[i0][j0][0] == dp[i1][j1][0])
                        dp[i][j][1] = Math.max(dp[i][j][1], Math.max(dp[i0][j0][2], dp[i1][j1][2]));
                    else {
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i1][j1][2]);
                    }
                    j0++;
                    i1++;
                }
                // 求 分数 + 和
                dp[i][j][2] = dp[i][j][0] + dp[i][j][1];
            }
        }

        return dp[0][n-1][1];
    }
}