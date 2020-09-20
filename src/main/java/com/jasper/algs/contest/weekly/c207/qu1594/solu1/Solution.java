package com.jasper.algs.contest.weekly.c207.qu1594.solu1;

/**
 * 1594. 矩阵的最大非负积
 * 
 * <p> 动态规划
 */
class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][][] dp = new long[n][m][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                long a = 0, b = 0, c = 0, d = 0;
                if(i!=0) {
                    a = dp[i-1][j][0] * grid[i][j];
                    b = dp[i-1][j][1] * grid[i][j];
                }

                if(j!=0) {
                    c = dp[i][j-1][0] * grid[i][j];
                    d = dp[i][j-1][1] * grid[i][j];
                }

                if(i!=0) {
                    dp[i][j][0] = Math.max(a, b);
                    dp[i][j][1] = Math.min(a, b);
                    if(j!=0) {
                        dp[i][j][0] = Math.max(dp[i][j][0], Math.max(c, d));
                        dp[i][j][1] = Math.min(dp[i][j][1], Math.min(c, d));
                    }
                } else if(j!=0) {
                    dp[i][j][0] = Math.max(c, d);
                    dp[i][j][1] = Math.min(c, d);
                }
            }
        }

        return dp[n-1][m-1][0] < 0 ? -1 : (int)(dp[n-1][m-1][0]%1_000_000_007);
    }
}