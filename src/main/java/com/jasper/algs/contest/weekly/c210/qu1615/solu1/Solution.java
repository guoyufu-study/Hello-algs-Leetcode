package com.jasper.algs.contest.weekly.c210.qu1615.solu1;

/**
 * 1615. 最大网络秩
 * 
 * <p> 暴力枚举：入度和
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // 邻接表
        int[] deg = new int[n];
        int[][] g = new int[n][n];
        for(int[] road : roads) {
            deg[road[0]]++;
            deg[road[1]]++;
            g[road[0]][road[1]] = g[road[1]][road[0]] = 1;
        }

        // 暴力枚举
        int ans = 0;
        for(int i=0; i<n; i++) 
            for(int j=i+1; j<n; j++) 
                ans = Math.max(ans, deg[i] + deg[j] - g[i][j]);
            
        return ans;
    }
}