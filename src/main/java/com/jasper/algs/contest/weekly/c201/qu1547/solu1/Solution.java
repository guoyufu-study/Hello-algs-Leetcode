package com.jasper.algs.contest.weekly.c201.qu1547.solu1;

import java.util.Arrays;

/**
 * 1547. 切棍子的最小成本
 * 
 * <p> 动态规划
 */
class Solution {
    public int minCost(int n, int[] cuts) {
        // 构造 cuts
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] tmp = new int[m+2];
        for(int i=0; i<m; i++) tmp[i+1] = cuts[i];
        tmp[m+1] = n;
        cuts = tmp;

        // 动态规划
        int[][] dp = new int[m+2][m+2];
        for(int delt=0; delt<m; delt++) {
            for(int i=1; i+delt<=m; i++) {
                int j = i+delt;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k-1] + dp[k+1][j]);
                }
                dp[i][j] += cuts[j+1]-cuts[i-1];
            }
        }

        return dp[1][m];
    }
}