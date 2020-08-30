package com.jasper.algs.contest.weekly.c095.qu0879.solu1;

/**
 * 0879. 盈利计划
 * 
 * <p> 动态规划
 */
class Solution {
	
    private static final int MOD = 1_000_000_007;

	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    	int n = group.length;
    	int[][][] dp = new int[n+1][P+1][G+1];
    	dp[0][0][0] = 1;
    	
    	for (int i = 1; i <= n; i++) {
    		dp[i][0][0] = 1;
    		int p0 = profit[i-1];  // 当前罪行盈利
            int g0 = group[i-1];  // 当前罪行成员数
            
            // 不选当前罪行
            for (int p1 = 0; p1 <= P; p1++) {
				for (int g1 = 0; g1 <= G; g1++) {
					dp[i][p1][g1] = dp[i-1][p1][g1];
				}
			}
            
            // 选当前罪行
            for (int p1 = 0; p1 <= P; p1++) {// 已盈利
				int p2 = Math.min(p1+p0, P);// 新盈利
				for (int g1 = 0; g1 <= G-g0; g1++) {// 已用成员数
					int g2 = g1 + g0; // 新成员数
					dp[i][p2][g2] += dp[i-1][p1][g1];
					dp[i][p2][g2] %= MOD;
				}
			}
		}
    	
    	long ans = 0;
    	for (int x : dp[n][P]) {
			ans += x;
		}
    	return (int) (ans%MOD);
    }
}