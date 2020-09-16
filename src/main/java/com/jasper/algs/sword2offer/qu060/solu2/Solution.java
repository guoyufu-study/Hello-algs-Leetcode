package com.jasper.algs.sword2offer.qu060.solu2;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 
 * <p> 动态规划
 */
class Solution {
    public double[] twoSum(int n) {
    	int[][] dp = new int[n+1][6*n+1];
    	for (int sum = 1; sum <= 6; sum++) {
			dp[1][sum] = 1;
		}
    	for (int m = 2; m <= n; m++) {
    		int limit = 6*m;
    		for (int sum = m; sum <= limit; sum++) {
				for (int i = 1; i <= 6; i++) {
					if(sum-i<m-1) break;
					dp[m][sum] += dp[m-1][sum-i];
				}
			}
		}
    	
    	double all = Math.pow(6, n);
    	double[] ans = new double[6*n-n+1];
    	for (int i = n; i <= 6*n; i++) {
			ans[i-n] = dp[n][i] / all;
		}
    	return ans;
    }
}